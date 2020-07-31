package com.wk.test1;

import com.wk.test.Person;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;


/**
 * @author WK
 * @create 2020-07-26-22:14
 */
public class LambdaP {
    List<Person> personList = Arrays.asList(new Person(2,2,"a"),
            new Person(3,8,"a"),
            new Person(4,5,"b"),
            new Person(2,7,"c"),
            new Person(3,6,"c"),
            new Person(2,5,"a"));
    @Test
    public void test1(){
        Collections.sort(personList,(e1,e2) -> {
            if (e1.getAge().equals(e2.getAge())){
                return Integer.compare(e1.getSalary(),e2.getSalary());
            }else {
                return -Integer.compare(e1.getAge(),e2.getAge());
            }
        });
        for (Person person : personList) {
            System.out.println(person);
        }
    }
    @Test
    public void test2(){
        String string = "abc";
        String s = strHandler(string, x -> x.toUpperCase());
        System.out.println(s);
        String string1 = "abv";
        String s1 = strHandler(string1, String::toUpperCase);
        System.out.println(s1);

    }
    //处理字符串
    public String strHandler(String string,MyFunction myFunction){
        return myFunction.getValues(string);
    }
    @Test
    public void test3(){
        longHandler(100L,200L,(x,y) -> x + y);
    }
    //处理2个long型
    public void longHandler(Long l1,Long l2,MyFunction2<Long,Long> myFunction){
        System.out.println(myFunction.getValue(l1,l2));
    }
    @Test
    public void test4(){
        Map<Integer, Map<String, List<Person>>> collect = personList.stream().collect(Collectors.groupingBy(Person::getSalary,
                Collectors.groupingBy(Person::getUsername)));
        for (Map.Entry<Integer, Map<String, List<Person>>> integerMapEntry : collect.entrySet()) {
            System.out.println(integerMapEntry.getKey());
            Map<String, List<Person>> value = integerMapEntry.getValue();
            for (Map.Entry<String, List<Person>> entry : value.entrySet()) {
                System.out.print(entry.getKey()+"-----");
                System.out.println(entry.getValue()+"--"+entry.getValue().size());
            }
        }
    }


}
