package com.algorithm.datastructure.baekjoon.dequeue;

import java.io.*;
import java.util.*;

public class BOJ_10866 {

    static int size = 10000;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] dequeue = new int[2*size+1];
        int head = size;
        int tail = size;

        int count = Integer.parseInt(br.readLine());

        for(int i = 0; i < count; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd){
                case "push_front":
                    dequeue[--head] = Integer.parseInt(st.nextToken());
                    break;
                case "push_back":
                    dequeue[tail++] = Integer.parseInt(st.nextToken());
                    break;
                case "pop_front":
                    int pf = head != tail ? dequeue[head++] : -1;
                    sb.append(pf + "\n");
                    break;
                case "pop_back":
                    int pb = head != tail ? dequeue[--tail] : -1;
                    sb.append(pb + "\n");
                    break;
                case "size":
                    sb.append(tail - head+ "\n");
                    break;
                case "empty":
                    sb.append((tail - head == 0 ? 1 : 0) + "\n");
                    break;
                case "front":
                    int f = head != tail ? dequeue[head] : -1;
                    sb.append(f + "\n");
                    break;
                case "back":
                    int b = head != tail ? dequeue[tail - 1] : -1;
                    sb.append(b + "\n");
                    break;
                default:
                    break;
            }

        }

        System.out.println(sb);

    }

}
