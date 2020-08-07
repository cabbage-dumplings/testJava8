package com.wk.test2;

import com.wk.test.Person;
import org.junit.Test;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Java8四大核心函数式接口
 * Consumer
 * @author WK
 * @create 2020-08-02-20:04
 */

public class TestLambda3 {

    @Test
    public void test1(){
        Person person = new Person();
        Supplier<Integer> supplier = person::getSocre;
        Integer integer = supplier.get();
        System.out.println(integer);
        System.out.println(Integer.compare(6,2));
    }

    @Test
    public void test2(){
        Function<Integer,Person> function = (x) -> new Person(x);
        Person apply = function.apply(100);
        System.out.println(apply);
        Function<Integer,Person> function1 = Person::new;
        Person apply1 = function1.apply(200);
        System.out.println(apply1);


    }

}
