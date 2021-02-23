package com.fxz.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fxz.entity.XwjUser;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述：
 *
 * @author Fang
 * @date 2021-02-18 09:20:41
 */
public class ObjectMapperTest {

    public static ObjectMapper mapper = new ObjectMapper();

    static {
        /* 转换为格式化的json */
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        /* 如果json中有新增的字段并且是实体类中不存在的，不报错 */
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Test
    public void testObj() throws IOException {

        XwjUser user = new XwjUser(1, "Hello World", new Date());

        // 对象信息写入文件中
        mapper.writeValue(new File("D:/test.txt"), user);

        String jsonStr = mapper.writeValueAsString(user);
        System.out.println("对象转字符串：" + jsonStr);

        byte[] byteArr = mapper.writeValueAsBytes(user);
        System.out.println("对象转字节数组：" + Arrays.toString(byteArr));

        XwjUser xwjUser1 = mapper.readValue(jsonStr, XwjUser.class);
        System.out.println("json字符串转对象：" + xwjUser1);

        XwjUser xwjUser2 = mapper.readValue(byteArr, XwjUser.class);
        System.out.println("字符数组转对象：" + xwjUser2);

    }

    @Test
    public void testList() throws IOException {

        List<XwjUser> userList = new ArrayList<>();
        userList.add(new XwjUser(1, "aaa", new Date()));
        userList.add(new XwjUser(2, "bbb", new Date()));
        userList.add(new XwjUser(3, "ccc", new Date()));
        userList.add(new XwjUser(4, "ddd", new Date()));

        String jsonStr = mapper.writeValueAsString(userList);
        System.out.println("集合转字符串：" + jsonStr);

        List<XwjUser> xwjUserList = mapper.readValue(jsonStr, List.class);
        System.out.println("字符串转集合：" + xwjUserList);

    }

    @Test
    public void testMap() throws IOException {

        Map<String, Object> map = new HashMap<>();
        map.put("name", "Jack");
        map.put("age", 24);
        map.put("date", new Date());
        map.put("user", new XwjUser(1, "aaa", new Date()));

        String jsonStr = mapper.writeValueAsString(map);
        System.out.println("map转json字符串：" + jsonStr);

        Map<String, Object> objectMap = mapper.readValue(jsonStr, Map.class);
        System.out.println("json字符串转map：" + objectMap);


    }

    @Test
    public void testOther() throws JsonProcessingException {

        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        XwjUser user = new XwjUser(1, "Hello", new Date());
        user.setIntList(Arrays.asList(1,2,3));

        String jsonStr = mapper.writeValueAsString(user);
        System.out.println("对象转字符串：" + jsonStr);

    }

}
