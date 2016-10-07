package cn.com.fullstack.study2;

import cn.com.fullstack.Salary;

import java.io.*;
import java.util.List;
import java.util.Random;

/**
 * Created by JM on 2016-10-1.
 */
public class Question3 {

    public static void main(String[] args) throws IOException {
        String fileName = "JavaIoSalaryFile.txt";
        int numbers = 10000000;
        int nameLength = 4;
        JavaIoSalary javaIoSalary = new JavaIoSalary(fileName,numbers,nameLength);
        Long genaFileStartTime = System.currentTimeMillis();
        javaIoSalary.genaretorSalaryData(fileName, numbers, nameLength);
        System.out.println("生成文件耗时："+(System.currentTimeMillis()-genaFileStartTime));
        Long startTime = System.currentTimeMillis();
        List<Salary> salaries = javaIoSalary.readSalaryData();
        javaIoSalary.handleSalaryData(salaries);
        javaIoSalary.outputSalaryTop(10);
        System.out.println("耗时："+(System.currentTimeMillis()-startTime));
    }

}
