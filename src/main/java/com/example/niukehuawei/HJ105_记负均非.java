package com.example.niukehuawei;

import java.util.Scanner;

// 统计负数 & 取非负数平均值
public class HJ105_记负均非 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int pCount = 0;
        int mCount = 0;
        long sum = 0;
        while(in.hasNextLong()){
            long cur = in.nextLong();
            if(cur < 0){
                mCount++;
            }
            else{
                sum += cur;
                pCount++;
            }
        }

        System.out.println(mCount);
        double pAvg = 0.0;
        if(pCount != 0){
            pAvg = Double.valueOf(sum) / pCount;
        }
        System.out.format("%.1f%n", pAvg);
        in.close();
    }
    // public static void main(String[] args) {
    //     Scanner in = new Scanner(System.in);
    //     int pCount = 0;
    //     int mCount = 0;
    //     BigDecimal sum = new BigDecimal("0");
    //     while(in.hasNextInt()){
    //         int cur = in.nextInt();
    //         if(cur < 0){
    //             mCount++;
    //         }
    //         else{
    //             sum = sum.add(new BigDecimal(Integer.toString(cur)));
    //             pCount++;
    //         }
    //     }

    //     System.out.println(mCount);
    //     double pAvg = 0.0;
    //     if(pCount != 0){
    //         pAvg = sum.divide(new BigDecimal(Integer.toString(pCount)),1,RoundingMode.HALF_UP).doubleValue();
    //     }
    //     System.out.format("%.1f%n", pAvg);
    //     in.close();
    // }
    
}


