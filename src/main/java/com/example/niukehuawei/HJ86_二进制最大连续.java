package com.example.niukehuawei;

import java.util.Scanner;

public class HJ86_二进制最大连续 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) { 
            int num = in.nextInt();
            int cur = 0;
            int max = 0;
            while(num != 0){
                if(num % 2 == 1){
                    cur++;
                    if(cur > max){
                        max = cur;
                    }
                }
                else {
                    cur = 0;
                }
                num /= 2;
            }
            System.out.println(max);
        }
        in.close();
    }
    
}
