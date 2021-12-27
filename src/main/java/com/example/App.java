package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // int a = -8;
        // System.out.println(Integer.toBinaryString(a));
        // a <<= 2;
        // System.out.println(Integer.toBinaryString(a));
        // a >>= 2;
        // System.out.println(Integer.toBinaryString(a));
        // a >>>= 3;
        // System.out.println(Integer.toBinaryString(a));

        Scanner in = new Scanner(System.in);
        // Pattern p = Pattern.compile("([0,1]?\\d{1,2}|2([0-4][0-9]|5[0-5]))(\\.([0,1]?\\d{1,2}|2([0-4][0-9]|5[0-5]))){3}");
        // while(in.hasNextLine()){
        //     String ip = in.nextLine();
        //     if(p.matcher(ip).matches()){
        //         System.out.println("YES");
        //     }
        //     else{
        //         System.out.println("NO");
        //     }
        // }
        


        // // 数字评分
        // String password = in.nextLine();
        // Pattern p = Pattern.compile("[a-z]");
        // Matcher m = p.matcher(password);
        // int numFlag = 0;
        // while(m.find()){
        //     numFlag ++;
        // }
        // System.out.println(numFlag);

        // boolean upperFlag = Pattern.matches("[A-Z]", password);
        // System.out.println(upperFlag);

        in.close();
        
        String[] arr = {"z,h,a,n,g", "s,a,n"};
        List<String> list = Arrays.asList(arr);
        System.out.println(list);
        List<String> collect = list.stream().flatMap(x -> {
            String[] array = x.split(",");
            Stream<String> stream = Arrays.stream(array);
            return stream;
        }).collect(Collectors.toList());
        System.out.println(collect);
    }
}
