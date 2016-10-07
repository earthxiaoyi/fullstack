package cn.com.fullstack.study4;

import cn.com.fullstack.Salary;
import cn.com.fullstack.study2.JavaIoSalary;

import java.io.IOException;
import java.util.List;

/**
 * Created by JM on 2016-10-6.
 */
public class MainTest {

    public static void main(String args[]) throws IOException {
        String fileName = "JavaIoSalaryFileByStream.txt";
        int numbers = 10000000;
        int nameLength = 4;
        JavaIoSalaryByStream javaIoSalary = new JavaIoSalaryByStream(fileName,numbers,nameLength);
        Long genaFileStartTime = System.currentTimeMillis();
        javaIoSalary.genaretorSalaryData(fileName, numbers, nameLength);
        System.out.println("生成文件耗时："+(System.currentTimeMillis()-genaFileStartTime));
        Long startTime = System.currentTimeMillis();
        List<Salary> salaries = javaIoSalary.readSalaryData();
        javaIoSalary.handleSalaryData(salaries);
        System.out.println("耗时："+(System.currentTimeMillis()-startTime));
    }
}
