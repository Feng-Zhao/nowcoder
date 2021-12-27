package com.example.juc.lock;

import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {

    public void test1 (){
        Thread thread = Thread.currentThread();

        System.out.println("a");
        LockSupport.unpark(thread);


        System.out.println("b");

        LockSupport.park();
        LockSupport.park();
        System.out.println("c");
        LockSupport.unpark(thread);
        LockSupport.park();
        System.out.println("d");
    }

    // other thread invoke this thread
    public void test2(){
        System.out.println("I'm parked");
        LockSupport.park();
        System.out.println("I'm release");
    }

    public static void main(String[] args) throws InterruptedException {
        LockSupportTest test = new LockSupportTest();
//        test.test1();

        Thread t = new Thread(()->{
           test.test2();
        });
        t.start();

        Thread.sleep(3000);
        LockSupport.unpark(t);
    }
}
