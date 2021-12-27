package com.example.niukehuawei;


import java.util.Scanner;
import java.util.regex.Pattern;


// IP 地址合法判断
public class HJ90_IP地址 {
    // 分段正则
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Pattern p = Pattern.compile("(\\d|1\\d{1,2}|(2(\\d|([0-4][0-9]|5[0-5])))|[3-9]\\d)");
        while(in.hasNextLine()){
            String ipStr = in.nextLine();
            boolean flag = true;
            String[] ips = ipStr.split("\\.");
            if(ips.length != 4){
                flag = false;
                System.out.println("NO");
                continue;
            }
            for (String ip : ips) {
                if(!p.matcher(ip).matches()){
                    flag = false;
                    break;
                }
            }
            if(flag){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
        in.close();
    }
    
    // 整体正则
    // public static void main(String[] args) {
    //     Scanner in = new Scanner(System.in);
    //     Pattern p = Pattern.compile("(\\d|1\\d{1,2}|(2(\\d|([0-4][0-9]|5[0-5])))|[3-9]\\d)(\\.(\\d|1\\d{1,2}|(2(\\d|([0-4][0-9]|5[0-5])))|[3-9]\\d)){3}");
    //     while(in.hasNextLine()){
    //         String ip = in.nextLine();
    //         if(p.matcher(ip).matches()){
    //             System.out.println("YES");
    //         }
    //         else{
    //             System.out.println("NO");
    //         }
    //     }
    //     in.close();
    // }
}

