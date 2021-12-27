package com.example.niukehuawei;

import java.util.Arrays;
import java.util.Scanner;

// 最长升序有间隔子序列长度
public class HJ103_最长升序子列 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        while(in.hasNextInt()){
            int len = in.nextInt();
            if(len == 1){
                System.out.println("1");
                in.close();
                return;
            }
            int[] nums = new int[len];
            int[] steps = new int[len];
            Arrays.fill(steps, 1);
            for (int i = 0; i < nums.length; i++) {
                nums[i] = in.nextInt();
            }
    
            int max = 1;
            for (int i = 1; i < steps.length; i++) {
                for (int j = 0; j < i; j++) {
                    if(nums[i] > nums[j] && steps[i] < steps[j] + 1){
                        steps[i] = steps[j] + 1;
                        max = Math.max(max, steps[i]);
                    }
                }
            }
    
            // System.out.println(Arrays.toString(nums));
            // System.out.println(Arrays.toString(steps));
            System.out.println(max);
        }
        
        in.close();
    }
    
}
