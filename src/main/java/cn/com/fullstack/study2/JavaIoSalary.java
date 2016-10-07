package cn.com.fullstack.study2;

import cn.com.fullstack.Salary;
import cn.com.fullstack.SalaryCount;

import java.io.*;
import java.util.*;

/**
 * Created by JM on 2016-10-1.
 */
public class JavaIoSalary extends BaseSalaryClass{

    private String fileName;
    private int numbers;
    private int nameLength;
    HashMap<String, SalaryCount> salaryMap = new HashMap<String,SalaryCount>();

    public JavaIoSalary(String fileName,int numbers,int nameLength){
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
        for(Salary salary:salaryList){
            String subsName = salary.getName().substring(0,2);
            if(salaryMap.containsKey(subsName)){
                SalaryCount salaryCount = salaryMap.get(subsName);
                salaryCount.setSlaryAdd(salaryCount.getSlaryAdd()+salary.getBaseSalary());
                salaryCount.setName(subsName);
                salaryCount.setNumbers(salaryCount.getNumbers() + 1);
                salaryMap.put(subsName,salaryCount);
            } else {
                SalaryCount salaryCount = new SalaryCount(subsName, salary.getBaseSalary(), 1);
                salaryMap.put(subsName,salaryCount);
            }
        }
    }

    @Override
    public void outputSalaryTop(int top){
        ArrayList<Map.Entry<String, SalaryCount>> entries = new
                ArrayList<Map.Entry<String, SalaryCount>>(salaryMap.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<String, SalaryCount>>() {
            @Override
            public int compare(Map.Entry<String, SalaryCount> o1, Map.Entry<String, SalaryCount> o2) {
                String key1 = o1.getKey();
                SalaryCount value1 = o1.getValue();
                String key2 = o2.getKey();
                SalaryCount value2 = o2.getValue();
                if(value1.getSlaryAdd()>value2.getSlaryAdd()){
                    return -1;
                }
                if(value1.getSlaryAdd()<value2.getSlaryAdd()){
                    return 1;
                }
                return 0;
            }
        });

        for (int i = 0; i < top; i++) {
            Map.Entry<String, SalaryCount> entry = entries.get(i);
            String key = entry.getKey();
            SalaryCount salaryCount = entry.getValue();
            System.out.println("names : "+key +" values : "+ salaryCount);
        }
    }
}
