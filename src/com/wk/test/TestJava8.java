package com.wk.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author WK
 * @create 2020-07-24-22:00
 */
public class TestJava8 {
    public static List<Person> people = Arrays.asList(new Person(1, 4),
            new Person(3, 3));
    public static void main(String[] args) {
        //lambda表达式
        List<Person> people1 = filterPerson(TestJava8.people, e -> e.getAge() > 3);
        people1.forEach(System.out::print);
        System.out.println("_____________________________________");

        //stream流处理
        people.stream().filter(a->a.getAge()>3).forEach(System.out::print);
        people.stream().map(Person::getSalary).forEach(System.out::print);
        System.out.println("_____________________________________");

        //匿名内部类
        List<Person> people2 = filterPerson(TestJava8.people, new MyPredicate<Person>() {
            @Override
            public Boolean test(Person person) {
                return person.getAge() > 3;
            }
        });
        people1.forEach(System.out::print);
        System.out.println("_____________________________________");
        //策略模式
        List<Person> people3 = filterPerson(TestJava8.people, new FilterAge());
        people1.forEach(System.out::print);
    }
    public static List<Person> filterPerson(List<Person> list,MyPredicate<Person> mp){
        ArrayList<Person> list1 = new ArrayList<>();
        for (Person p:list){
            if (mp.test(p)){
                list1.add(p);
            }
        }
        return list1;
    }

}
