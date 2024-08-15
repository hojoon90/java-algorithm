package com.algorithm.datastructure.baekjoon.queue;

import java.io.*;
import java.util.*;

public class BOJ_18258 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cmdCnt = Integer.parseInt(br.readLine());
        int[] queue = new int[2000001];
        int front = 0;
        int back = 0;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < cmdCnt; i++) {
            String cmdTxt = br.readLine();
            StringTokenizer st = new StringTokenizer(cmdTxt);
            String cmd = st.nextToken();

            switch(cmd){
                case "push":
                    queue[back++] = Integer.parseInt(st.nextToken());
                    break;
                case "front":
                    int ftemp = front != back ? queue[front] : -1;
                    sb.append(ftemp + "\n");
                    break;
                case "back":
                    int btemp = front != back ? queue[back-1] : -1;
                    sb.append(btemp + "\n");
                    break;
                case "size":
                    int size = back - front;
                    sb.append(size + "\n");
                    break;
                case "empty":
                    int isEmpty = front == back ? 1 : 0;
                    sb.append(isEmpty + "\n");
                    break;
                case "pop":
                    if(front != back) {
                        sb.append(queue[front++] + "\n");
                    }else{
                        sb.append(-1 + "\n");
                    }
                    break;
                default:
                    break;
            }
        }

        System.out.println(sb.toString());
    }
}
