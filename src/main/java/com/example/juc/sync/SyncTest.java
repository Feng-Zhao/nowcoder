package com.example.juc.sync;

public class SyncTest {

    public static void main(String[] args) {
        Ticket t = new Ticket(3000);
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

class Ticket{
    Integer left;
    Ticket(int left){
        this.left = left;
    }
    // synchronized 控制, 原理为重量级锁 monitor enter/ monitor exit 优化后改为 偏向锁-自旋锁-重量级锁
    synchronized void sell(){
        System.out.println(Thread.currentThread().getName()+ "卖出了第 " + left-- +" 张票. 剩余: " + left);
    }
}
