package com.example.niukehuawei;

import java.util.Scanner;

// 负数记录总数, 正数取和平均,保留一位小数, 0 不做处理, 
public class HJ97_记负均正 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int len = in.nextInt();
            long sum = 0;
            int pCount = 0;
            int nCount = 0;
            for (int i = 0; i < len; i++) {
                int cur = in.nextInt();
                if (cur < 0) {
                    nCount++;
                } else if (cur > 0) {
                    sum += cur;
                    pCount++;
                }
            }
            System.out.format("%d ", nCount);
            double avg = (double)sum / pCount;
            System.out.format("%.1f%n",avg);
        }
        in.close();
    }
}
