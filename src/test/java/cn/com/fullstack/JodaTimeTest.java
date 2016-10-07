package cn.com.fullstack;

import org.joda.time.DateTime;

import java.util.Date;

/**
 * Created by JM on 2016-10-5.
 */
public class JodaTimeTest {

    public static void main(String args[]){
        DateTime nowTime = new DateTime().now();
        Date date = nowTime.toDate();
        //Date date1 = nowTime.toLocalDateTime().toDate();
        //System.out.println(date1);
        System.out.println(date);
    }
}
