package cn.com.fullstack.study4;

import java.util.stream.Stream;

/**
 * Created by JM on 2016-10-6.
 */
public class Question2 {
    public static void main(String args[]){
        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return true;
                })
                .forEach(s -> System.out.println("forEach: " + s));
    }
}
