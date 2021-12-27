package com.example.juc.wait;

import java.util.ArrayList;
import java.util.List;

class Task2 implements Runnable{
    MyLock lock;

    public Task2(MyLock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock){
            while(lock.count > 0){
                try {
                    lock.count--;
                    System.out.println(Thread.currentThread().getName() + " run, count is " + lock.count);
                    lock.notify();
                    lock.wait();
                }catch (InterruptedException e){
                    return;
                }
            }
        }
    }
}

public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        List<Thread> ts = new ArrayList<>();
        MyLock lock = new MyLock(50);
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new Task2(lock),String.valueOf(i));
            ts.add(t);
            t.start();
        }

        Thread.sleep(10000);
        for (Thread t: ts
             ) {
            t.interrupt();
        }
    }
}
