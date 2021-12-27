package com.example.niukehuawei;

import java.util.Scanner;

public class HJ107_二分法求立方根 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double num = in.nextDouble();
        if(num == 0){
            System.out.println("0.0");
            in.close();
            return;
        }
        int flag = num > 0 ? 1 : -1;
        double pNum = num > 0 ? num : -num;

        double top = 0;
        double bottom = 0;
        while(top*top*top < pNum){
            top++;
        }
        bottom = top - 1;

        double mid = bottom + (top - bottom)/2;
        while(top - bottom > 0.1){
            if(mid*mid*mid > pNum){
                top = mid;
            }
            else{
                bottom = mid;
            }
            mid = bottom + (top - bottom)/2;
        }

        System.out.format("%.1f%n",mid*flag);

        in.close();
    }
}
