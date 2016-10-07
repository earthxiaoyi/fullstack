package cn.com.fullstack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * Created by JM on 2016-10-6.
 */
public class LambdaTest {

    public static void main(String args[]){

        Thread thread = new Thread(() -> {
            System.out.println("hello lambda!");
        });
        thread.start();

        final Consumer<String> stringConsumer = (String s) -> System.out.println(s);
        stringConsumer.accept("333");
        //java 8 stream操作数组
        List<String> myList = Arrays.asList("a1", "b2", "c33", "t5", "i9","a8");
        Stream<String> stream = myList.stream();
        stream.
            filter(s -> s.startsWith("a")).
            map(String::toUpperCase).
            sorted().
            forEach(System.out::println);

        //操作ArrayList
        List<Person> personArrayList = new ArrayList<Person>();
        for (int i = 0; i < 10; i++) {
            Person person = new Person("李四" + i, 10 + i);
            personArrayList.add(person);
        }
        personArrayList.stream().
            filter(p->p.getAge()>15).
            forEach(System.out::println);
        ;
        System.out.println("=======");
        personArrayList.stream().
                filter(p -> p.getAge() > 15).
                max((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge())).
                ifPresent(System.out::println);

        System.out.println("=======");
        personArrayList.stream().
                filter(p->p.getAge()>15).
                reduce((p1, p2) -> p1.getAge() > p2.getAge() ? p1 : p2).
                ifPresent(System.out::println);

        System.out.println("=======");
        personArrayList.stream().
                filter(p -> p.getAge() > 15).
                map(Person::getAge).
                reduce((x1,x2) -> x1+x2).
                ifPresent(System.out::println);

        System.out.println("=======");
        Person person = personArrayList.stream().
                filter(p -> p.getAge() > 15).
                reduce(new Person("", 0), (p1, p2) -> {
                    p1.setAge(p1.getAge() + p2.getAge());
                    p1.setName(p1.getName() + p2.getName());
                    System.out.println(p1);
                    return p1;
                });
        System.out.println(person);

        System.out.println("=============================================================");
        Integer reduce = personArrayList.stream().
                filter(p -> p.getAge() > 15).
                reduce(0, (sum, p) -> {
                    System.out.println("sum="+sum+"  p="+p);
                    return sum + p.getAge();
                }, (sum1, sum2) -> {
                    System.out.println("sum1="+sum1+"  sum2="+sum2);
                    return sum1 + sum2;}
                );
        System.out.println(reduce);

        System.out.println("==========================并行方式=============================");
        Integer reduce1 = personArrayList.parallelStream().
                filter(p -> p.getAge() > 15).
                reduce(0, (sum, p) -> {
                            System.out.println("sum="+sum+"  p="+p);
                            return sum + p.getAge();
                        }, (sum1, sum2) -> {
                            System.out.println("sum1="+sum1+"  sum2="+sum2);
                            return sum1 + sum2;}
                );
        System.out.println(reduce);
        //操作HashMap

    }


}

class Person{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
