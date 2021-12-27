package com.example.niukehuawei;

import java.util.Scanner;

public class HJ33_ip整数转换 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            // ip 2 int
            String ip = in.nextLine();
            String[] ips = ip.split("\\.");
            long result = 0;
            for (int i = 0; i < 4; i++) {
                result = result << 8;
                result += Integer.parseInt(ips[i]);
            }
            System.out.println(result);

            // int 2 ip

            long num = Long.parseLong(in.nextLine());
            String[] ipStr = new String[4];

            for (int i = 0; i < 4; i++) {
                long part = num & 0xff;
                ipStr[i] = Long.toString(part);
                num = num >> 8;
            }
            StringBuilder sb = new StringBuilder(ipStr[3]);
            for (int i = 2; i >= 0; i--) {
                sb.append(".").append(ipStr[i]);
            }
            System.out.println(sb.toString());

        }
        in.close();
    }

}
