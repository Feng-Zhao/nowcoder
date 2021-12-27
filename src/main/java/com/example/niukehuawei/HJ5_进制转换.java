package com.example.niukehuawei;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class HJ5_进制转换 {
    private static final int srcSystem = 16;
    private static final char signal = 'x';

    public static void main(String[] args) {
        Map<Character,Integer> map = new HashMap<>();
        map.put('0',0);
        map.put('1',1);
        map.put('2',2);
        map.put('3',3);
        map.put('4',4);
        map.put('5',5);
        map.put('6',6);
        map.put('7',7);
        map.put('8',8);
        map.put('9',9);
        map.put('a',10);
        map.put('b',11);
        map.put('c',12);
        map.put('d',13);
        map.put('e',14);
        map.put('f',15);
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            char[] str = in.nextLine().toLowerCase(Locale.ROOT).toCharArray();
            int order = srcSystem;
            int sum = map.get(str[str.length-1]);
            for (int i = str.length-2; i >=0 ; i--) {
                if(str[i] != signal){
                    sum += order * map.get(str[i]);
                    order *= srcSystem;
                } else {
                    break;
                }
            }
            System.out.println(sum);
        }
        in.close();
    }
}
