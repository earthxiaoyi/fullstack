package cn.com.fullstack.study4;

import cn.com.fullstack.Salary;
import cn.com.fullstack.SalaryCount;
import cn.com.fullstack.study2.BaseSalaryClass;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by JM on 2016-10-1.
 */
public class JavaIoSalaryByStream extends BaseSalaryClass{

    private String fileName;
    private int numbers;
    private int nameLength;
    HashMap<String, SalaryCount> salaryMap = new HashMap<String,SalaryCount>();

    public JavaIoSalaryByStream(String fileName, int numbers, int nameLength){
        this.fileName = fileName;
        this.numbers = numbers;
        this.nameLength = nameLength;
    }

    @Override
    public List<Salary> readSalaryData() {
        List<Salary> salaryArrayList = new ArrayList<Salary>(numbers);
        Reader reader = null;
        BufferedReader bufferedReader = null;
        try {
            reader = new FileReader("src/main/resources/"+fileName);
            bufferedReader = new BufferedReader(reader);
            String line = null;
            while((line = bufferedReader.readLine()) != null){
                StringTokenizer s = new StringTokenizer(line,",");
                Salary salary = new Salary(s.nextToken(),Integer.parseInt(s.nextToken()),Integer.parseInt(s.nextToken()));
                salaryArrayList.add(salary);
            }
        }  catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                reader.close();
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return salaryArrayList;
    }

    @Override
    public void handleSalaryData(List<Salary> salaryList) {
        Map<String, List<Salary>> collect = salaryList.parallelStream().
                filter(s -> s.getBaseSalary() * 12 + s.getBonus() > 100000).
                map(s -> {
                    s.setName(s.getName().substring(0, 2));
                    return s;
                }).
                collect(Collectors.groupingBy(s -> s.getName()));

        collect.entrySet().
                stream().
                map(s -> {
                    String name = s.getKey();
                    long sum = s.getValue().parallelStream().
                            reduce(0L,
                                    (salarySum, salary) -> salarySum += salary.getBaseSalary() * 12 + salary.getBonus(),
                                    (s1, s2) -> s1 + s2);
                    SalaryCount salaryCount = new SalaryCount(name,sum,s.getValue().size());
                    return salaryCount;
                }).sorted((s1,s2)->{
                    if(s1.getSlaryAdd()>s2.getSlaryAdd()){
                        return -1;
                    }
                    if(s1.getSlaryAdd()<s2.getSlaryAdd()){
                        return 1;
                    }
                    return 0;
                }).
                limit(10).
                forEach(s->System.out.println(s));
    }

    @Override
    public void outputSalaryTop(int top){

    }
}
