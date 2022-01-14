package com.example.niukehuawei;

import java.util.Scanner;

public class HJ9_数字反序去重 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        while (in.hasNextInt()) {
            int a = in.nextInt();
            boolean[] visited = new boolean[10];
            String str = String.valueOf(a);
            int[] nums = new int[str.length()];

            for (int i = nums.length - 1; i >= 0; i--) {
                nums[i] = a % 10;
                a = a / 10;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = nums.length - 1; i >= 0; i--) {
                if(!visited[nums[i]]){
                    sb.append(str.charAt(i));
                    visited[nums[i]] = true;
                }
            }
            System.out.println(sb.toString());
        }
        in.close();
    }
}
