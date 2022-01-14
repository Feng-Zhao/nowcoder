package com.example.niukehuawei;

import java.util.Arrays;
import java.util.Scanner;

public class HJ24_合唱队_左右最长子序列 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            int total = Integer.valueOf(in.nextLine());
            String[] highs = in.nextLine().split(" ");
            int[] highNums = Arrays.stream(highs).mapToInt(Integer::valueOf).toArray();

            int[] dpl = new int[highNums.length];
            Arrays.fill(dpl, 1);
            int[] dpr = new int[highNums.length];
            Arrays.fill(dpr, 1);

            for (int i = 0; i < highNums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if(highNums[j] < highNums[i]){
                        dpl[i] = Math.max(dpl[i],dpl[j]+1);
                    }
                }
            }

            for (int i = highNums.length-1; i >= 0; i--) {
                for (int j = highNums.length-1; j > i; j--) {
                    if(highNums[i]>highNums[j]){
                        dpr[i] = Math.max(dpr[i], dpr[j]+1);
                    }
                }
            }
            int max = 0;
            for (int i = 0; i < dpl.length; i++) {
                if(dpl[i] + dpr[i] - 1 > max){
                    max = dpl[i] + dpr[i] - 1;
                }
            }
            System.out.println(total-max);
        }
    }
}
