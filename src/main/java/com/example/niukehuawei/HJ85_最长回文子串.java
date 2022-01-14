package com.example.niukehuawei;

import java.util.Scanner;

public class HJ85_最长回文子串 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str = in.nextLine();

        if(str == null || str.length() == 0){
            System.out.println("0");
            in.close();
            return;
        }

        int max = 1;
        for (int start = 0; start < str.length() - 2; start++) {
            for (int end = str.length() - 1; end > start; end--) {
                if(check(str, start ,end)){
                    if(end - start + 1 > max ){
                        max = end - start + 1;
                    }
                }
            }
            
        }
        
        System.out.println(max);
        in.close();
    }

    static boolean check (String str, int start, int end){
        while(start < end){
            if(str.charAt(start) != str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    
}
