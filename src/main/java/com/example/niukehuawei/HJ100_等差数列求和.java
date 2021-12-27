package com.example.niukehuawei;

import java.util.Scanner;

// (2,3)等差数列 求前n项和
public class HJ100_等差数列求和 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while(in.hasNextInt()){
            int n = in.nextInt();
            int result = ( (2+(3*(n-1) + 2) ) * n ) / 2;
            System.out.println(result);
        }
        in.close();
    }
}
