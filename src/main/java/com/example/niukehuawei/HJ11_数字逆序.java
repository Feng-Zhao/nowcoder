package com.example.niukehuawei;

import java.util.Scanner;

public class HJ11_数字逆序 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int num = in.nextInt();
            StringBuilder sb = new StringBuilder();
            if(num == 0){
                System.out.println(num);
            }
            else{
                while(num != 0){
                    sb.append(num % 10);
                    num /= 10;
                }
                System.out.println(sb.toString());
            }
        }
        in.close();
    }
    
}
