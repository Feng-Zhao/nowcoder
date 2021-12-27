package com.example.niukehuawei;

import java.util.Scanner;

public class HJ34_字符串ascii排序 {
    // 使用流 stream -> intstream -> .sorted().foreach()
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            StringBuilder sb = new StringBuilder();
            String str = in.nextLine();
            str.chars().sorted().forEach(
                x -> sb.append((char)x)
            );
            System.out.println(sb.toString());
        }
        in.close();
    }

    // 由于字符有限且不多,使用 hashmap 记录每个字符出现的次数,然后按顺序按频次组装 string
    
}
