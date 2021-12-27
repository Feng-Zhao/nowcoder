package com.example;

import java.math.BigDecimal;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

public class PlayGround {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InterruptedException {
        CountDownLatch cl = new CountDownLatch(5);
        Random random = new Random(10086);
        ReentrantLock lock = new ReentrantLock();
        new Thread(()->{
            try {
                System.out.println("test is waiting ...");
                cl.await();
                System.out.println("test is done");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"test").start();

        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                try {
                    int time = 1000 * random.nextInt(10);
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() +": I'm awake");
                cl.countDown();
                System.out.println(Thread.currentThread().getName()+":cl now is " + cl.getCount());
            },"t"+i).start();
        }

        cl.await();
        System.out.println("main stop");

    }

    
}
class MyTest{

    
}