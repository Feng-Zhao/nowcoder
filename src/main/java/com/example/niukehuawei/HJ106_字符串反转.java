package com.example.niukehuawei;

import java.util.Scanner;

// 字符串反转
public class HJ106_字符串反转 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        StringBuilder sb = new StringBuilder(str);
        System.out.println(sb.reverse());
        in.close();
    }
    
}
