package com.example.juc.sync;

import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    public static void main(String[] args) {
        NomalTicket t = new NomalTicket(3000);
        new Thread(()->{
            for (int i = 1; i < 1001; i++) {
                t.sell();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 1; i < 1001; i++) {
                t.sell();
            }
        },"B").start();
        new Thread(()->{
            for (int i = 1; i < 1001; i++) {
                t.sell();
            }
        },"C").start();

    }
}

class NomalTicket{
    ReentrantLock lock = new ReentrantLock();
    Integer left;
    NomalTicket(int left){
        this.left = left;
    }
    // synchronized 控制, 原理为重量级锁 monitor enter/ monitor exit 优化后改为 偏向锁-自旋锁-重量级锁
    void sell(){
        lock.lock();
        System.out.println(Thread.currentThread().getName()+ "卖出了第 " + left-- +" 张票. 剩余: " + left);
        lock.unlock();
    }
}