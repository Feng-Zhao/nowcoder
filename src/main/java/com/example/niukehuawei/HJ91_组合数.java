package com.example.niukehuawei;

import java.util.Scanner;

// c(n+m)(n)
public class HJ91_组合数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int n = in.nextInt();
            int m = in.nextInt();
            int min = n < m ? n : m;
            int a = 1; // 分子
            int b = 1; // 分母
            for (int i = 1; i <= min; i++) {
                b *= i; // 1*2*3*4...min
            }
            for (int i = m+n; i > m+n-min; i--) {
                a *= i; // n*(n-1)*(n-2)...(n-m+1)
            }
            System.out.println(a/b);
        }
        in.close();
    }
}
