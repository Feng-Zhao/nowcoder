package com.example.niukehuawei;

import java.util.Scanner;

public class HJ12_字符反转 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            String str = in.nextLine();
            StringBuilder sb = new StringBuilder();
            for (int i = str.length()-1; i >= 0; i--) {
                sb.append(str.charAt(i));
            }
            System.out.println(sb.toString());
        }
        in.close();
    }
}
