package com.example.juc.wait;

class MyLock{
    int count;

    public MyLock( int count) {
        this.count = count;
    }
}

class Task implements Runnable{
    MyLock lock;

    public Task(MyLock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock){
            while (lock.count > 0){
                try {
                    lock.notifyAll();
                    lock.count--;
                    System.out.println(Thread.currentThread().getName() + "run 1, now count is " + lock.count);
                    lock.wait();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}

public class Test {
    public static void main(String[] args) {
        MyLock lock = new MyLock(10);
        new Thread(new Task(lock),"a").start();
        new Thread(new Task(lock),"b").start();
    }
}

