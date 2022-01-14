package com.example.niukehuawei;

import java.util.Scanner;

public class HJ6_质因数分解 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int n = in.nextInt();

            int k = 2;
            while(n % 2 == 0){
                System.out.print(k+" ");
                n = n / 2;
            }
            k++;
            while(n != 1 && k <= Math.sqrt(n)){
                if(n % k == 0){
                    System.out.print(k+" ");
                    n = n / k;
                }
                else {
                    k+=2;
                }
            }
            if(n != 1){
                System.out.print(n+" ");
            }
        }
        in.close();

    }
    
}
