package com.wk.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author WK
 * @create 2020-07-31-19:39
 */
public class TestEvalute {
    public static void main(String[] args) {
        List<Person> list = Arrays.asList(new Person(1,1,"a"),
                new Person(2,2,"b"),
                new Person(3,3,"c"));
        for (Person person : list) {
            System.out.println(person.getAge()+" "+person.getSalary()+" "+person.getUsername());
        }
        System.out.println("aa");
        System.out.println("bb");
        System.out.println("cc");
	    System.out.println("green");
        System.out.println("baicia");
        System.out.println("新的分支");
	System.out.println("拉取分支");
        int a = 1;
        int b = 2;
        System.out.println(add(a,b));
    }
    public static int add(int a,int b){
        return a+b;
    }
}
