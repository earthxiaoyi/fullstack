package cn.com.fullstack.study6;

import cn.com.fullstack.Salary;
import cn.com.fullstack.SalaryCount;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;

/**
 * Created by jiaming.jiang on 2016/10/10.
 */
public class Main {
    public static void main(String args[]) throws IOException {
        String fileName = "ConcurrentFile.txt";
        int numbers = 10000000;
        int nameLength=4;
        ConcurrentUtils<HashMap<String, SalaryCount>> concurrentUtils = new ConcurrentUtils(8);
        BaseSalaryClass baseSalary = new BaseSalaryClass();
        Long genFileStime = System.currentTimeMillis();
        baseSalary.genaretorSalaryData(fileName,numbers,nameLength);
        System.out.println("生成文件耗时："+(System.currentTimeMillis()-genFileStime));
        Long readDataStime = System.currentTimeMillis();
        List<Salary> salaryList = baseSalary.readSalaryData(numbers, fileName);
        System.out.println("读取文件耗时："+(System.currentTimeMillis()-readDataStime));
        Long outprintStime = System.currentTimeMillis();
        //分割任务
        List<Callable> callableList = new ArrayList<>();
        int flag = salaryList.size() / 8;
        for (int i = 1; i <=8 ; i++) {
            if(i==8){
                callableList.add(new JavaIoSalary(salaryList.subList((i - 1) * flag + 1, salaryList.size())));
            }else {
                callableList.add(new JavaIoSalary(salaryList.subList((i - 1) * flag + 1, i * flag)));
            }
        }
        List<Future<HashMap<String, SalaryCount>>> futureList = concurrentUtils.submit(callableList);
        List<HashMap<String, SalaryCount>> results = concurrentUtils.getResults(futureList);
        //汇总数据
        HashMap<String, SalaryCount> dataMap = results.get(0);
        results.remove(dataMap);
        for (HashMap<String, SalaryCount> result : results) {
            Set<Map.Entry<String, SalaryCount>> entries = result.entrySet();
            for(Map.Entry<String, SalaryCount> entry:entries){
                String key = entry.getKey();
                SalaryCount value = entry.getValue();
                if(dataMap.containsKey(key)){
                    SalaryCount salaryCount = dataMap.get(key);
                    salaryCount.setNumbers(value.getNumbers()+salaryCount.getNumbers());
                    salaryCount.setSlaryAdd(value.getSlaryAdd()+salaryCount.getSlaryAdd());
                }else{
                    dataMap.put(key,value);
                }
            }
        }
        baseSalary.outputSalaryTop(dataMap,10);
        System.out.println("数据处理、汇总、排序输出耗时："+(System.currentTimeMillis()-outprintStime));

        //关闭线程池
        concurrentUtils.shutDown();
    }
}
