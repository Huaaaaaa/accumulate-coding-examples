package com.accumulate.coding.basic.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2022/1/10 3:38 下午
 * @description: 区分flatMap和map
 * flatMap:必须接受一个Stream，如果传入元素不是Stream，需要先将其转成Stream
 * map:可以接受任意类型，Stream或非Stream
 */
public class StreamOperation {


    public static void main(String[] args) {

        ArrayList<String[]> userList = new ArrayList<>();
        userList.add(new String[]{"鸡蛋-01", "鸡蛋-02", "鸡蛋-03", "鸡蛋-04", "鸡蛋-05"});
        userList.add(new String[]{"鸡蛋-11", "鸡蛋-12", "鸡蛋-13", "鸡蛋-14", "鸡蛋-15"});
        StreamOperation streamOperation = new StreamOperation();
        streamOperation.modifyUserListArray(userList);
        List<String> userNameList = Arrays.asList("鸡蛋-01", "鸡蛋-02", "鸡蛋-03", "鸡蛋-04", "鸡蛋-05");
        streamOperation.modifyUserList(userNameList);
    }


    public void modifyUserListArray(List<String[]> userList) {
        System.out.println("===modifyUserListArray:flatmap===");
        userList.stream().flatMap(array -> Arrays.stream(array).map(name -> name.replace("鸡", "煎"))).forEach(System.out::println);
        System.out.println("===modifyUserListArray:map===");
        userList.stream().map(array -> Arrays.stream(array).map(name -> name.replace("鸡", "煎"))).forEach(users -> System.out.println(Arrays.toString(users.toArray())));
    }

    public void modifyUserList(List<String> userList) {
        System.out.println("===modifyUserList:flatmap===");
        userList.stream().flatMap(name -> Arrays.stream(new String[]{name.replace("鸡", "煎")})).forEach(System.out::println);
        System.out.println("===modifyUserList:map===");
        userList.stream().map(name -> name.replace("鸡", "煎")).forEach(System.out::println);
    }
}
