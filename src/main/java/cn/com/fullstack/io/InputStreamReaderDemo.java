package cn.com.fullstack.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Created by jiaming on 2018/4/23.
 */
public class InputStreamReaderDemo {
    public static void main(String[] args) throws Exception{
        FileInputStream fileInputStream = new FileInputStream(new File("src/main/resources/FileInputStreamDemo.txt"));
        InputStreamReader reader = new InputStreamReader(fileInputStream,"utf-8");
        BufferedReader bufferedReader = new BufferedReader(reader);
        String s = null;
        while((s = bufferedReader.readLine())!= null){
            System.out.println(s);
        }
    }
}
