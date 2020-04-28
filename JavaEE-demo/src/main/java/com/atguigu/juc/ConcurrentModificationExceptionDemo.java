package com.atguigu.juc;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author Maple
 * @create 2020-04-27 21:44
 *
 * java.util.ConcurrentModificationException 并发修改异常
 * 故障原因
 * ArrayList没有加锁，导致遍历list是数组长度不一致
 * 解决方案
 * 1、vector
 * 2、conllections.synchronizedList(new ArrayList())
 * 3、copyonWiteArrayList(); 写时复制
 */
public class ConcurrentModificationExceptionDemo {

    public static void main(String[] args) {

        Map map = new ConcurrentHashMap();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,6));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }



//        Set set = new CopyOnWriteArraySet();
//        for (int i = 0; i < 30; i++) {
//            new Thread(() -> {
//                set.add(UUID.randomUUID().toString().substring(0,6));
//                System.out.println(set);
//            }, String.valueOf(i)).start();
//        }




//        List<String> list = //new ArrayList()
//                 //Collections.synchronizedList(new ArrayList<>());
//                new CopyOnWriteArrayList();
//
//        for (int i = 0; i < 30; i++) {
//            new Thread(() -> {
//                list.add(UUID.randomUUID().toString().substring(0,6));
//                System.out.println(list);
//            }, String.valueOf(i)).start();
//        }


    }



}
