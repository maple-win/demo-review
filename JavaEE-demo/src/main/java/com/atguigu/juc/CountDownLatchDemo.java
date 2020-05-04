package com.atguigu.juc;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;

/**
 * @author Maple
 * @create 2020-04-29 10:27
 *
 * 顺序执行
 * 一组线程，指定主线程必须最后执行
 */

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"\t 号同学已离开");
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t 班长锁门离开");
        CompletableFuture<Object> objectCompletableFuture = new CompletableFuture<>();
    }



}


class yinghang{

    public void ying1(){
        BigDecimal bigDecimalA = new BigDecimal("1111111412");
        BigDecimal bigDecimalB = new BigDecimal("784212000.021165132");
        BigDecimal add = bigDecimalA.add(bigDecimalB);
    }

    /**
     * 输入数字找出正整数中的偶数并输出相加值
     */
    public void ying2(){
        Scanner scanner = new Scanner(System.in);

//        do {
//            System.out.println("输入0.0，退出输出！");
//            float v = scanner.nextFloat();
//        }while ()
    }



}