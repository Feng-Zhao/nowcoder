package com.example.niukehuawei;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HJ93_等和分组 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int len = in.nextInt();
            // 读取
            int sum5 = 0;
            int sum3 = 0;
            int sumOther = 0;
            List<Integer> rest = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                int cur = in.nextInt();
                if(cur % 5 == 0){
                    sum5 += cur;
                }else if(cur % 3 == 0){
                    sum3 += cur;
                }else{
                    sumOther += cur;
                    rest.add(cur);
                }
            }

            // 提前判断是否可以均分
            if( (sum5 - sum3 + sumOther) % 2 != 0){
                System.out.println("false");
            }
            else {
                int target = (sum5 - sum3 + sumOther) / 2;
                boolean[] selected = new boolean[rest.size()];
                int[] allOption = new int[rest.size()];
                for (int i = 0; i < rest.size(); i++) {
                    allOption[i] = rest.get(i);
                }

                if(canSplit(selected,allOption ,target)){
                    System.out.println("true");
                }
                else {
                    System.out.println("false");
                }
            }
        }
        in.close();
    }

    // 深度优先遍历
    private static boolean canSplit(boolean[] selected,int[] allOption, int target){
        if(target == 0){
            return true;
        }

        for (int i = 0; i < allOption.length; i++) {
            if(!selected[i]){
                selected[i] = true;
                if(canSplit(selected,allOption,target-allOption[i])){
                    return true;
                }
                else{
                    selected[i] = false;
                }
            }
        }
        return false;
    }
}
