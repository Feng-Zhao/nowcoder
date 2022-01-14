package com.example.niukehuawei;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class HJ26_字符串排序 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) { 
            char[] chars = in.nextLine().toCharArray();
            List<Character> letters = new ArrayList<>();

            for (int i = 0; i < chars.length; i++) {
                if(Character.isLetter(chars[i])){
                    letters.add(chars[i]);
                }
            }

            letters.sort(new Comparator<Character>() {
                @Override
                public int compare(Character o1, Character o2) {
                    if(Character.toLowerCase(o1) > Character.toLowerCase(o2)){
                        return 1;
                    }
                    else if(Character.toLowerCase(o1) < Character.toLowerCase(o2)){
                        return -1;
                    }
                    else{
                        return 0;
                    }
                }
            });

            StringBuilder sb = new StringBuilder();
            int cur = 0;
            for (int i = 0; i < chars.length; i++) {
                if(Character.isLetter(chars[i])){
                    sb.append(letters.get(cur));
                    cur++;
                }
                else{
                    sb.append(chars[i]);
                }
            }

            System.out.println(sb.toString());
        }
    }
}
