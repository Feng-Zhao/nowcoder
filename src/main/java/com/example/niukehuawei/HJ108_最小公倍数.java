package com.example.niukehuawei;
import java.util.Scanner;


// 最小公倍数 (最小公约数)
public class HJ108_最小公倍数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        
        // int c = find1(a,b);
        int c = find2(a,b);

        int result = a * b / c;
        System.out.println(result);
        in.close();
    }
    
    // 辗转相除法 大 / 小 取余数, 直到商为0
    static int find1(int a, int b){
        int max = Math.max(a, b);
        int min = Math.min(a,b);
        int mod = max % min;
        while(mod != 0){
            max = min;
            min = mod;
            mod = max % min; 
        }
        return min;
    }

    // 更相减损术 大减小 直到大小相等
    static int find2(int a , int b){
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        int temp;
        while(max != min){
            temp = Math.max(max - min,min);
            min = Math.min(max - min,min);
            max = temp;
        }
        return max;
    }
}