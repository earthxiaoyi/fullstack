package cn.com.fullstack.study2;

import cn.com.fullstack.Salary;

import java.io.*;
import java.util.List;
import java.util.Random;

/**
 * Created by JM on 2016-10-1.
 */
public abstract class BaseSalaryClass {

    public void genaretorSalaryData(String fileName,int numbers,int nameLength) throws IOException {
        File salaryFile = new File("src/main/resources/"+fileName);
        FileOutputStream fileOutputStream = null;
        Writer writer = null;
        try {
            fileOutputStream = new FileOutputStream(salaryFile);
            writer = new OutputStreamWriter(fileOutputStream,"UTF-8");
            Random random = new Random();
            for(int i=1;i<=numbers;i++){
                String salaryName = genaretorSalaryName(nameLength);
                int baseSalary = random.nextInt(20)*800;
                int bonus = random.nextInt(10)*1000;
                writer.write(salaryName + "," + baseSalary + "," + bonus+"\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            writer.flush();
            writer.close();
            fileOutputStream.close();
        }
    }

    public String genaretorSalaryName(int nameLength){
        String randomStr = "qwertyuiopasdfghjklzxcvbnm";
        StringBuffer buffer = new StringBuffer();
        Random random = new Random();
        while(nameLength>0){
            char c = randomStr.charAt(random.nextInt(randomStr.length()));
            buffer.append(c);
            nameLength--;
        }
        return buffer.toString();
    }

    public abstract List<Salary> readSalaryData();

    public abstract void handleSalaryData(List<Salary> salaryList);

    public abstract void outputSalaryTop(int top);
}
