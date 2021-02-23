package com.fxz.test;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fxz.entity.Student;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 描述：
 *
 * @author Fang
 * @date 2021-02-18 14:26:53
 */
public class StudentTest {

    public static ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Test
    public void testObj() throws IOException {

        Student s1 = new Student(1, "Jack", 18, "计科2");
        mapper.writeValue(new File("D:/student.txt"), s1);

        String student1 = mapper.writeValueAsString(s1);
        System.out.println("对象转json字符串：" + student1);

        byte[] bytes = mapper.writeValueAsBytes(s1);
        System.out.println("对象转字符数组：" + Arrays.toString(bytes));

        Student student2 = mapper.readValue(student1, Student.class);
        System.out.println("json字符串转对象：" + student2);

        Student student3 = mapper.readValue(bytes, Student.class);
        System.out.println("字符数组转对象：" + student3);

    }

    @Test
    public void testList() throws IOException {

        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "张三", 18, "计科1"));
        list.add(new Student(2, "李四", 19, "计科2"));
        list.add(new Student(3, "王五", 20, "计科1"));

        String s1 = mapper.writeValueAsString(list);
        System.out.println("集合转字符串：" + s1);

        List<Student> studentList = mapper.readValue(s1, List.class);
        System.out.println("字符串转集合：" + studentList);

    }

}
