package com.example.niukehuawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;


// 合并同类项
public class HJ8_合并索引同类项 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int len = in.nextInt();
        
        Map<Integer,Integer> map = new HashMap<>();
        // reading
        for(int i = 0; i < len; i++){
            int index = in.nextInt();
            int value = in.nextInt();
            // calculate
            if(map.containsKey(index)){
                map.put(index,map.get(index) + value);
            }
            else{
                map.put(index,value);
            }
        }
        // output
        for (Entry<Integer,Integer> entry : map.entrySet()) {
            System.out.format("%d %d%n",entry.getKey(),entry.getValue());
        }
        in.close();
    }
}
