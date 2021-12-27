package com.example.niukehuawei;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HJ89_穷举24点运算 {
    public static void main(String[] args) {
        // 准备 card to int
        Map<String,Integer> cardToIntMap = new HashMap<>();
        cardToIntMap.put("A", 1);
        cardToIntMap.put("2", 2);
        cardToIntMap.put("3", 3);
        cardToIntMap.put("4", 4);
        cardToIntMap.put("5", 5);
        cardToIntMap.put("6", 6);
        cardToIntMap.put("7", 7);
        cardToIntMap.put("8", 8);
        cardToIntMap.put("9", 9);
        cardToIntMap.put("10", 10);
        cardToIntMap.put("J", 11);
        cardToIntMap.put("Q", 12);
        cardToIntMap.put("K", 13);
        cardToIntMap.put("joker", -1);
        cardToIntMap.put("JOKER", -1);

        String[] intToString = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};


        // reading and set card[]
        int[] card = new int[4];
        Scanner in = new Scanner(System.in);
        for(int i = 0; in.hasNext(); i++){
            String cardStr = in.next();
            int cardNum = cardToIntMap.get(cardStr);
            if(cardNum == -1){
                System.out.println("ERROR");
                in.close();
                return;
            }
            card[i] = cardNum;
        }
        in.close();

        // 准备 回溯
        int[] symbol = {43,45,42,47}; // + - * / ascii码
        final boolean CALCULATE = true;
        final boolean NUM = false;
        boolean flag = CALCULATE;

        // 路径
        int[] result = new int[7]; // 存储表达式
        Arrays.fill(result,-1); // 初值为 -1 , 因为result 要记录card pos, 不能用0


        try {
            // 回溯填充 result
            if (find(result,card,symbol,0)) {
                // 找到结果时 组装 表达式
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < result.length; i++) {
                    if (i % 2 == 0) {
                        sb.append(intToString[card[result[i]]-1]);
                    } else {
                        sb.append((char) result[i]);
                    }
                }
                System.out.println(sb.toString());
                return;
            }
            System.out.println("NONE");
            return;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static boolean find(int[] curResult,int[] availableCard, int[] symbol, int cursor) throws Exception {
        if(cursor == 7){
            return test(curResult,availableCard);
        }

        for(int i = 0; i < availableCard.length; i++){
            // 选择一个未使用的card放入路径
            if(!hasUsedCard(curResult,i,cursor)){
                curResult[cursor] = i;
                if(cursor + 1 < 7){
                    // 选择一个操作放入路径
                    for (int j = 0; j < symbol.length; j++) {
                        curResult[cursor+1] = symbol[j];
                        if(find(curResult,availableCard,symbol,cursor+2)){
                            return true;
                        }
                    }
                }
                else {
                    if(find(curResult,availableCard,symbol,cursor+1)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean hasUsedCard(int[] curResult,int cardPos,int cursor){
        int i = 0;
        while (curResult[i] != -1 && i < cursor){
            if(curResult[i] == cardPos){
                return true;
            }
            i+=2;
        }
        return false;
    }

    private static boolean test(int[] result,int[] card) throws Exception {
        // 检测表达式是否为 24
        int sum = card[result[0]];
        for (int i = 2; i < 7; i+=2) {
            switch (result[i-1]){
                case '+': sum += card[result[i]];break;
                case '-': sum -= card[result[i]];break;
                case '*': sum *= card[result[i]];break;
                case '/': sum /= card[result[i]];break;
                default: throw new Exception("只能计算+-*/");
            }
        }
        return sum == 24;
    }
    
}
