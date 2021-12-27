package com.example.niukehuawei;

import java.util.Scanner;

public class HJ32_最长回文子序列 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        int start, end;
        int min_s = s.length()-1;
        int max_e = 0;
        int max_p_len = 0;

        for (start = 0; start<s.length() - max_p_len ; start++ ){
            for(end = s.length()-1; end >= start; end--) {
                int inner_s = start;
                int inner_e = end;
                boolean is_P = true;

                while (inner_s <= inner_e) {
                    if (s.charAt(inner_s) == s.charAt(inner_e)) {
                        inner_s++;
                        inner_e--;
                    } else {
                        is_P = false;
                        break;
                    }
                }
                if(is_P){
                    if((end-start) > (max_e-min_s)){
                        max_e = end;
                        min_s = start;
                        max_p_len = max_e - min_s + 1;
                    }
                }
            }
        }
        // System.out.println(s.substring(min_s,max_e+1));
        System.out.println(max_e - min_s + 1);
    }
}
