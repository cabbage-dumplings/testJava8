package com.wk.test;

/**
 * @author WK
 * @create 2020-07-24-22:47
 */
public class FilterAge implements MyPredicate<Person>{
    @Override
    public Boolean test(Person person) {
        return person.getAge()>3;
    }
}
