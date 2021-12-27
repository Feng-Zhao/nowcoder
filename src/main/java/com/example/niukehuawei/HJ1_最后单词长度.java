package com.example.niukehuawei;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HJ1_最后单词长度 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        Pattern p = Pattern.compile("[a-zA-Z]+$");
        Matcher m = p.matcher(str);
        if(m.find()){
            System.out.println(m.end()-m.start());
        }
        in.close();
    }
}
