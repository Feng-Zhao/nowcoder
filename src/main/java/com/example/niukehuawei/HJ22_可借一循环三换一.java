package com.example.niukehuawei;

import java.util.Scanner;

public class HJ22_可借一循环三换一 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            if(n == 0) break;
            int count = 0;
            while(n > 2){
                count += n / 3;
                n = (n / 3) + (n % 3);
            }
            if(n == 2){
                count++;
            }
            System.out.println(count);
        }
        in.close();
    }
    
}
