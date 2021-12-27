package com.example.niukehuawei;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HJ92_最长数字字串 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Pattern p = Pattern.compile("\\d+");
        // 对于每组输入
        while (in.hasNextLine()){
            // 读取
            String str = in.nextLine();
            Matcher m = p.matcher(str);
            // 空头节点
            Node92 head = new Node92();
            // 将每组匹配按匹配长度放入链表合适位置
            while(m.find()){
                String sub = m.group();
                Node92 node = new Node92(sub,m.start(),sub.length());
                Node92 cur = head;
                while (cur.next != null && cur.next.len > node.len){
                    cur = cur.next;
                }
                node.next = cur.next;
                cur.next = node;
            }

            // 打印
            if(head.next != null){
                String result = "";
                int len = head.next.len;
                while(head.next != null && head.next.len == len){
                    result = head.next.str + result;
                    head = head.next;
                }
                System.out.println(result + "," + len);
            }
        }
        in.close();
    }
}

class Node92{
    String str;
    int index;
    int len;
    Node92 next;

    public Node92() {
    }

    public Node92(String str, int index, int len) {
        this.str = str;
        this.index = index;
        this.len = len;
    }
}
