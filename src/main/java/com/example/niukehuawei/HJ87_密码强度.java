package com.example.niukehuawei;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class HJ87_密码强度 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Pattern upperLetter = Pattern.compile("[A-Z]");
        Pattern lowerLetter = Pattern.compile("[a-z]");
        Pattern numPattern = Pattern.compile("\\d");
        Pattern dotPattern = Pattern.compile("([\\x21-\\x2F]|[\\x3A-\\x40]|[\\x5B-\\x60]|[\\x7B-\\x7E])");

        while(in.hasNextLine()){
            String password = in.nextLine();
            int result = 0;
            // 长度评分
            if(password.length() > 7){
                result += 25;
            }
            else if(password.length() > 4){
                result += 10;
            }
            else{
                result += 5;
            }
            // 字母评分
            Matcher upperLetterMatcher = upperLetter.matcher(password);
            Matcher lowerLetterMatcher = lowerLetter.matcher(password);
            boolean upperFlag = upperLetterMatcher.find();
            boolean lowerFlag = lowerLetterMatcher.find();
            if(upperFlag & lowerFlag){
                result += 20;
            }
            else if(upperFlag ^ lowerFlag){
                result += 10;
            }

            // 数字评分
            Matcher numMatcher = numPattern.matcher(password);
            int numFlag = 0;
            while(numMatcher.find()){
                numFlag ++;
                if(numFlag > 1){
                    break;
                }
            }
            if(numFlag == 1){
                result += 10;
            }
            else if (numFlag > 1){
                result += 20;
            }

            // 符号评分
            Matcher dotMatcher = dotPattern.matcher(password);
            int dotFlag = 0;
            while(dotMatcher.find()){
                dotFlag++;
                if(dotFlag > 1){
                    break;
                }
            }
            if(dotFlag == 1){
                result += 10;
            }
            else if(dotFlag > 1){
                result += 25;
            }

            // bonous
            if((upperFlag | lowerFlag) && numFlag > 0){
                result += 2;
                if(dotFlag > 0){
                    result += 1;
                    if(upperFlag & lowerFlag){
                        result += 2;
                    }
                }
            }

            // output
            if(result >= 90){
                System.out.println("VERY_SECURE");
            }
            else if (result >= 80){
                System.out.println("SECURE");
            }
            else if (result >= 70){
                System.out.println("VERY_STRONG");
            }
            else if (result >= 60){
                System.out.println("STRONG");
            }
            else if (result >= 50){
                System.out.println("AVERAGE");
            }
            else if (result >= 25){
                System.out.println("WEAK");
            }
            else{
                System.out.println("VERY_WEAK");
            }
            System.out.println(result);
        }
        in.close();
    }
}
