package com.example.niukehuawei;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HJ4_字符串定长分割 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String str = in.nextLine();
            int count = str.length() % 8 != 0 ? 8 - (str.length() % 8) : 0;
            StringBuilder sb = new StringBuilder(str);
            for (int i = 0; i < count; i++) {
                sb.append("0");
            }
            Pattern p = Pattern.compile(".{8}");
            Matcher m = p.matcher(sb.toString());
            while (m.find()){
                System.out.println(m.group());
            }
        }
        in.close();
    }
}
