package com.example.niukehuawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HJ23_删除出现次数最少字符 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine();
            Map<Character,Integer> map = new HashMap<>();
            for (char c : str.toCharArray()) {
                map.put(c,map.getOrDefault(c, 0) + 1);
            }
            int min = Integer.MAX_VALUE;
            for (Integer i : map.values()) {
                if(i < min){
                    min = i;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (char c : str.toCharArray()) {
                if(map.get(c) != min){
                    sb.append(c);
                }
            }
            System.out.println(sb.toString());
        }
        in.close();
    }
}
