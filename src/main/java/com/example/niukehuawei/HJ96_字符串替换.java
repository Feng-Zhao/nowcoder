package com.example.niukehuawei;

import java.util.Scanner;

public class HJ96_字符串替换 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            String str = in.nextLine();
            String result = str.replaceAll("\\d+", "\\*$0\\*");
            System.out.println(result);
        }
        in.close();
    }
}
