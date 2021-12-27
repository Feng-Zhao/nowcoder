package com.example.niukehuawei;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class HJ3_去重排序 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int len = in.nextInt();
            Set<Integer> set = new TreeSet<>();
            for (int i = 0; i < len; i++) {
                set.add(in.nextInt());
            }
            for (Integer i : set) {
                System.out.println(i);
            }
        }
        in.close();
    }
}
