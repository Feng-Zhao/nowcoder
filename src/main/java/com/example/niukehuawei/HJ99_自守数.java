package com.example.niukehuawei;

import java.util.Scanner;

public class HJ99_自守数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int num = in.nextInt();
            int count = 0;
            for (int i = 0; i <= num; i++) {
                if(Integer.valueOf(i*i).toString().endsWith(String.valueOf(i))){
                    count++;
                }
            }
            System.out.println(count);
        }
        in.close();
    }

}
