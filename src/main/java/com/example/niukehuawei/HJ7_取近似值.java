package com.example.niukehuawei;

import java.util.Scanner;

// 取近似值
public class HJ7_取近似值 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextDouble()){
            System.out.println(Math.round(in.nextDouble()));
        }
        in.close();
    }
}