package com.example.juc.interrupt;

public class InterruptTest {


    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(
                ()->{
                    while (!Thread.currentThread().isInterrupted()){
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            System.out.println("进入catch");
                            System.out.println(Thread.currentThread().isInterrupted());
                            Thread.currentThread().interrupt();
                            System.out.println("interrupt 之后");
                            System.out.println(Thread.currentThread().isInterrupted());
                        }
                    }
                }
        );

        t.start();
        Thread.sleep(300);
        System.out.println("即将打断线程");
        t.interrupt();
    }
}
