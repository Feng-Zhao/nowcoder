package com.example.niukehuawei;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HJ31_单词倒排 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Pattern pattern = Pattern.compile("[A-Za-z]+");

        while(in.hasNextLine()){
            String str = in.nextLine();
            Matcher matcher = pattern.matcher(str);
            Deque<String> stack = new LinkedList<>();
            while(matcher.find()){
                stack.push(matcher.group());
            }
            while(!stack.isEmpty()){
                System.out.print(stack.pop()+" ");
            }
            
        }
        in.close();
    }
}
