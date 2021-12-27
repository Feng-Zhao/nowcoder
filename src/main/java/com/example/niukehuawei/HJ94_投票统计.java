package com.example.niukehuawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HJ94_投票统计 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            // 读取
            int len = Integer.parseInt(in.nextLine());
            String[] nameStr = in.nextLine().split(" ");
            int countLen = Integer.parseInt(in.nextLine());
            String[] voteStr = in.nextLine().split(" ");

            // 统计
            Map<String, Integer> nameToPos = new HashMap<>();
            int[] voteCount = new int[nameStr.length + 1];

            nameToPos.put("Invalid", 0);
            for (int i = 0; i < len; i++) {
                nameToPos.put(nameStr[i], i+1);
            }

            for (String vote : voteStr) {
                int pos = nameToPos.getOrDefault(vote, 0);
                voteCount[pos] = voteCount[pos] + 1;
            }

            // 输出
            for (int i = 0; i < len; i++) {
                System.out.format("%s : %d%n",nameStr[i],voteCount[nameToPos.get(nameStr[i])]);
            }
            System.out.format("Invalid : %d%n",voteCount[0]);
        }
        in.close();
    }
}
