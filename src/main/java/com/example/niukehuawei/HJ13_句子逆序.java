package com.example.niukehuawei;

import java.util.Scanner;

public class HJ13_句子逆序 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            String[] strArray = str.split(" ");
            StringBuilder sb = new StringBuilder();
            for (int i = strArray.length - 1; i > 0; i--) {
                sb.append(strArray[i] + " ");
            }
            sb.append(strArray[0]);
            System.out.println(sb.toString());
        }
        in.close();
    }
}
