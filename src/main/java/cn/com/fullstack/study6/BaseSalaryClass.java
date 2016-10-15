package cn.com.fullstack.study6;

import cn.com.fullstack.Salary;
import cn.com.fullstack.SalaryCount;

import java.io.*;
import java.util.*;

/**
 * Created by JM on 2016-10-1.
 */
public class BaseSalaryClass {

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

    public List<Salary> readSalaryData(int numbers,String fileName) {
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

    public void outputSalaryTop(HashMap<String, SalaryCount> salaryMap,int top){
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
    }}
