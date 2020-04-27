package com.atguigu.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Maple
 * @create 2020-04-27 16:31
 * 买票
 */


class Ticket {
    private int number = 50;
    private Lock lock = new ReentrantLock();

    public void sale() {
        lock.lock();
        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "\t 卖出第" + (number--) + "\t 张票，还剩 \t" + number + "\t 张票");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}


public class JUCDemo {

    public static void main(String[] args) {

        Ticket ticket = new Ticket();


        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 55; i++) {
                    ticket.sale();
                }
            }
        }, "a").start();

        new Thread(()->{
            for (int i = 0; i < 55; i++) {
                ticket.sale();
            }
        },"b").start();
    }

}
