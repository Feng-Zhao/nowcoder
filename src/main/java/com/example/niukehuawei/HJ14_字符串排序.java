package com.example.niukehuawei;

import java.util.PriorityQueue;
import java.util.Scanner;

public class HJ14_字符串排序 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        PriorityQueue<String> q = new PriorityQueue<>();
        int num = Integer.valueOf(in.nextLine());
        for (int i = 0; i < num; i++) {
            q.offer(in.nextLine());
        }
        while(!q.isEmpty()){
            System.out.println(q.poll());
        }
        in.close();
    }
}
