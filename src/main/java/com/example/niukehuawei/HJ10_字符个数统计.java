package com.example.niukehuawei;

import java.util.Scanner;

public class HJ10_字符个数统计 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            String line = in.nextLine();
            boolean[] visited = new boolean[127];
            int count = 0;
            for (int i = 0; i < line.length(); i++) {
                if(!visited[Integer.valueOf(line.charAt(i))]){
                    count++;
                    visited[Integer.valueOf(line.charAt(i))] = true;
                }
            }
            System.out.println(count);
        }
        in.close();
    }
}
