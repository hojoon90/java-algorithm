package com.algorithm.datastructure.boj.queue;

import java.io.*;
import java.util.*;

public class BOJ_10845 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cmdCnt = Integer.parseInt(br.readLine());
        String[] queue = new String[10001];
        int front = 0;
        int back = 0;


        for (int i = 0; i < cmdCnt; i++) {
            String cmdTxt = br.readLine();
            StringTokenizer st = new StringTokenizer(cmdTxt);
            String cmd = st.nextToken();

            switch(cmd){
                case "push":
                    queue[back++] = st.nextToken();
                    break;
                case "front":
                    String ftemp = front != back ? queue[front] : "-1";
                    System.out.println(ftemp);
                    break;
                case "back":
                    String btemp = front != back ? queue[back-1] : "-1";
                    System.out.println(btemp);
                    break;
                case "size":
                    int size = back - front;
                    System.out.println(size);
                    break;
                case "empty":
                    int isEmpty = front == back ? 1 : 0;
                    System.out.println(isEmpty);
                    break;
                case "pop":
                    if(front != back) {
                        System.out.println(queue[front++]);
                    }else{
                        System.out.println("-1");
                    }
                    break;
                default:
                    break;
            }


        }

    }
}
