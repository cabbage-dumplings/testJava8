package com.wk.test;

/**
 * @author WK
 * @create 2020-07-24-22:41
 */
public class Person{
    @Override
    public String toString() {
        return "Person{" +
                "salary=" + salary +
                ", age=" + age +
                ", username='" + username + '\'' +
                '}';
    }


    Person(Integer salary, Integer age) {
        this.salary = salary;
        this.age = age;
    }

    public Person(Integer salary, Integer age, String username) {
        this.salary = salary;
        this.age = age;
        this.username = username;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private Integer salary;
    private Integer age;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
