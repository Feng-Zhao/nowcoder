package com.example.juc.wait;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * 注: 一般不这么写, 一般把 wait notify 卸载队列的 存和取里
 * 生产者消费者 直接用存取方法,这里只是演示 wait notify 使用
 * 且本例不是 典型的生产者消费者 模型, 典型的生产者消费者只在 队列满/空时才阻塞
 */
public class Producer implements Runnable {
    List<String> queue;
    Random random = new Random();

    public Producer(List<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        synchronized (queue) {
            while (queue.size() < 10) {
                try {
                    Thread.sleep(1000);
                    String str = String.valueOf(random.nextInt());
                    queue.add(str);
                    System.out.println(Thread.currentThread().getName() + " push " + str + " in");
                    queue.notifyAll();
                    queue.wait();
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        List<String> q = new LinkedList<>();
        List<Thread> tList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            Thread p = new Thread(new Producer(q), "P " + i);
            tList.add(p);
            p.start();
        }
        for (int i = 0; i < 3; i++) {
            Thread c = new Thread(new Consumer(q), "C " + i);
            tList.add(c);
            c.start();
        }
        Thread.sleep(10000);
        for (Thread t : tList
        ) {
            t.interrupt();
        }

    }
}
