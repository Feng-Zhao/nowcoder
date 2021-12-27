package com.example.niukehuawei;
import java.util.Arrays;
import java.util.Scanner;


// 根据标识位 排序 0 升 1 降
public class HJ101_标识位升降序{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int len = in.nextInt();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = in.nextInt();
        }
        // 0 升 1 降
        int flag = in.nextInt();

        Arrays.sort(nums);
        
        if(flag == 0){
            for (int i = 0; i < len; i++) {
                System.out.print(nums[i]+" ");
            }
        }
        else if(flag == 1){
            for (int i = len-1; i >= 0; i--) {
                System.out.print(nums[i]+" ");
            }
        }
        else{
            in.close();
            throw new RuntimeException("the flag is illegal");
        }
        in.close();
    }

}