package com.example.niukehuawei;

import java.util.Scanner;

// 二进制数 1 的数量
public class HJ15_二进制统计1bit {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        
        int result = 0;
        
        // 与操作
        for(int i = 0; i < 32; i++){
            if((num&1) == 1){
                result++;
            }
            num = num >>> 1;
        }
        
        
        // 求二进制
//         while(num != 0){
//             if(num % 2 == 1){
//                 result++;
//             }
//             num/=2;
//         }
        
        // 工具类
        // result = Integer.bitCount(num);

        // 转 string
        // String bStr = Integer.toBinaryString(num);
        // bStr = bStr.replace("0", "");
        // System.out.println(bStr);
        // result = bStr.length();
        
        System.out.println(result);
        in.close();
    }
    
}
