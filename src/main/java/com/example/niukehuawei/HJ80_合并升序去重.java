package com.example.niukehuawei;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

// 整型数组 升序合并, 过滤重复元素
public class HJ80_合并升序去重 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);

            while(in.hasNextInt()){
                int aLen = in.nextInt();
                Set<Integer> set = new TreeSet<>();
                for (int i = 0; i < aLen; i++) {
                    set.add(in.nextInt());
                }
                int bLen = in.nextInt();
                for (int i = 0; i < bLen; i++) {
                    set.add(in.nextInt());
                }
                set.stream().forEach((Integer i)->{System.out.print(i);});
                System.out.println();
            }
            in.close();
        }
}
