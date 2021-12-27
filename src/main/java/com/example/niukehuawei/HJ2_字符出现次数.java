package com.example.niukehuawei;

import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HJ2_字符出现次数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine().toLowerCase(Locale.ROOT);;
        String target = in.nextLine().toLowerCase(Locale.ROOT);

        Pattern p = Pattern.compile(target);
        Matcher m = p.matcher(str);
        int count = 0;
        while (m.find()){
            count++;
        }
        System.out.println(count);
        in.close();
    }
}
