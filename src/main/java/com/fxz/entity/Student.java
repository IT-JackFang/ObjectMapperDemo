package com.fxz.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 描述：
 *
 * @author Fang
 * @date 2021-02-18 14:26:39
 */
public class Student implements Serializable {

    private static final long serialVersionUID = 605741609894653108L;

    private int id;
    private String name;
    private int age;
    private String className;
    private List<String> grades;

    public Student() { }

    public Student(int id, String name, int age, String className) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.className = className;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<String> getGrades() {
        return grades;
    }

    public void setGrades(List<String> grades) {
        this.grades = grades;
    }

    @Override
    public String toString() {
        return "{\"Student\":{"
                + "\"id\":"
                + id
                + ",\"name\":\""
                + name + '\"'
                + ",\"age\":"
                + age
                + ",\"className\":\""
                + className + '\"'
                + ",\"grades\":"
                + grades
                + "}}";
    }

}
