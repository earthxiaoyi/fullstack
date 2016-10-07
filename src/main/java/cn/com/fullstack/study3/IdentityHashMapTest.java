package cn.com.fullstack.study3;

import java.util.IdentityHashMap;

/**
 * Created by JM on 2016-10-5.
 */
public class IdentityHashMapTest {
    public static void main(String args[]){
        IdentityHashMap map = new IdentityHashMap();
        Integer a=5;
        Integer b=5;
        System.out.println(a == b);
        map.put(a, "100");
        map.put(b, "100");
        System.out.println(map.size());
        map.clear();
        a=Integer.MAX_VALUE;
        b=Integer.MAX_VALUE;
        System.out.println(a == b);
        map.put(a,"100");
        map.put(b,"100");
        System.out.println("a="+a.toString()+"  b="+b.toString());
        System.out.println(map.size());
    }
}
