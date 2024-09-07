package com.algorithm.dp.boj2;

import java.io.*;
import java.util.*;

public class BOJ_1463_2 {

    static int[] d = new int[1000001];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 2; i <= N; i++) {
            d[i] = d[i-1]+1;
            if(i % 2 == 0) d[i] = Math.min(d[i], d[i/2]+1);
            if(i % 3 == 0) d[i] = Math.min(d[i], d[i/3]+1);
        }

        System.out.println(d[N]);
    }

}
