package cn.com.fullstack.study6;

import cn.com.fullstack.Salary;
import cn.com.fullstack.SalaryCount;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;
import java.util.concurrent.Callable;

/**
 * Created by JM on 2016-10-1.
 */
public class JavaIoSalary implements Callable {

    private String fileName;
    private int numbers;
    private int nameLength;
    private HashMap<String, SalaryCount> salaryMap = new HashMap<String,SalaryCount>();
    private List<Salary> salaryList;

    public JavaIoSalary(List<Salary> salaryList){
        this.salaryList = salaryList;
    }

    public void handleSalaryData() {
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
    public Object call() throws Exception {
        this.handleSalaryData();
        return salaryMap;
    }
}
