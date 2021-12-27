package com.example.juc.wait;

import java.util.List;

public class Consumer implements Runnable {
    List<String> queue;

    public Consumer(List<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        synchronized (queue) {
            while (!queue.isEmpty()) {
                try {
                    Thread.sleep(1000);
                    String str = queue.remove(0);
                    System.out.println(Thread.currentThread().getName() + " take " + str + " out");
                    queue.notifyAll();
                    queue.wait();
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }
}
