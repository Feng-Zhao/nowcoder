package com.example.juc.join;

public class JoinTest {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(
                ()->{
                    for (int i = 0; i < 10; i++) {
                        try {
                            Thread.sleep(1000);
                            System.out.println("inner sleep " + i + " seconds");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("inner finished");
                }
        );

        t.start();

        for (int i = 0; i < 3; i++) {
            Thread.sleep(1000);
            System.out.println("outer sleep " + i + " seconds");
            if(i == 1){
                System.out.println("inner join");
                t.join();
            }
        }
        System.out.println("outer finished");
    }

}
