package com.example.niukehuawei;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Map.Entry;

// 根据频次降序,同频ASCII升序
public class HJ102_频升排序 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            String str = in.nextLine();
            Map<Character, Integer> map = new HashMap<>();
            for (char c : str.toCharArray()) {
                map.put(c,map.getOrDefault(c, 0)+1);
            }
            Queue<Entry<Character,Integer>> q = new PriorityQueue<>(new Comparator<Entry<Character,Integer>>() {

                @Override
                public int compare(Entry<Character,Integer> o1, Entry<Character,Integer> o2) {
                    if(o1.getValue() > o2.getValue()){
                        return -1;
                    }
                    else if(o1.getValue() < o2.getValue()){
                        return 1;
                    }
                    else{
                        return o1.getKey() > o2.getKey() ? 1 : -1;
                    }
                }
                
            });
            q.addAll(map.entrySet());
            while(!q.isEmpty()){
                System.out.print(q.poll().getKey());
            }
            System.out.println("");
        }
        in.close();
    }
}