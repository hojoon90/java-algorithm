package com.algorithm.linkedarray.baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1158 {

    public static int[] pre = new int[5001];
    public static int[] next = new int[5001];
    public static int len = 0;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] param = br.readLine().split(" ");
        int N = Integer.parseInt(param[0]);
        int K = Integer.parseInt(param[1]);

        for(int i = 1; i <= N; i++){
            pre[i] = i == 1 ? N : i - 1;
            next[i] = i == N ? 1 : i + 1;
            ++len;
        }

        LinkedList<Integer> list = new LinkedList<>();
        int i = 1;
        for (int cur = 1; len != 0; cur = next[cur]){
            if(i == K){
                pre[next[cur]] = pre[cur];
                next[pre[cur]] = next[cur];
                list.add(cur);
                i = 1;
                --len;
            }else{
                ++i;
            }
        }

        String result = list.toString();
        result = result.replace("[", "<").replace("]", ">");

        System.out.println(result);

    }

}
