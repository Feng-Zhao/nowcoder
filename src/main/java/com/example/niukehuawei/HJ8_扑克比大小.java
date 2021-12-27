package com.example.niukehuawei;

import java.util.Scanner;

public class HJ8_扑克比大小 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            String str = in.nextLine();
            String[] decks = str.split("-");
            String[] a = decks[0].split(" ");
            String[] b = decks[1].split(" ");
            DECK aDeck = getType(a);
            DECK bDeck = getType(b);
            // 同等牌型
            if(aDeck.equals(bDeck)){
                if(isABigger(a,b)){
                    System.out.println(decks[0]);
                }
                else{
                    System.out.println(decks[1]);
                }
            }
            else{
                // ERROR
                if(!aDeck.equals(DECK.BOMB) && !aDeck.equals(DECK.JJ) && !bDeck.equals(DECK.BOMB) && !bDeck.equals(DECK.JJ)){
                    System.out.println("ERROR");
                }
                // 有炸弹或者双王
                else{
                    if(aDeck.ordinal() > bDeck.ordinal()){
                        System.out.println(decks[0]);
                    }
                    else{
                        System.out.println(decks[1]);
                    }
                }
            }
        }
        in.close();
    }

    public static DECK getType(String[] deck){
        int len = deck.length;
        DECK type = null;
        switch(len){
            case 1:type = DECK.SINGEL;break;
            case 3:type = DECK.TRI;break;
            case 4:type = DECK.BOMB;break;
            case 5:type = DECK.STRAIGHT;break;
        }
        if(len == 2){
            if(deck[0].equals(deck[1])){
                type = DECK.PAIR;
            }
            else{
                type = DECK.JJ;
            }
        }
        return type;
    }

    public static boolean isABigger(String[] a, String[] b){
        int aNum = 0;
        int bNum = 0;
        String[] card = {"3","4","5","6","7","8","9","10","J","Q","K","A","2","joker","JOKER"};
        for (int i = 0; i < card.length; i++) {
            if(a[0].equals(card[i])){
                aNum = i;
            }
            if(b[0].equals(card[i])){
                bNum = i;
            }
        }
        return aNum >= bNum;
    }
    

    enum DECK {
        SINGEL,PAIR,TRI,STRAIGHT,BOMB,JJ
    }
}
