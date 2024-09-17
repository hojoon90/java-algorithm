package com.algorithm.study.retryqueue.retry01;

import java.io.*;
import java.util.*;

/*
https://www.acmicpc.net/problem/10844
 */
public class BOJ_10844 {

    static int[][] d = new int[101][10];

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i < 10; i++) {
            d[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                if(j != 0) d[i][j] += d[i-1][j-1];
                if(j != 9) d[i][j] += d[i-1][j+1];
                d[i][j] %= 1000000000;
            }
        }

        System.out.println(Arrays.stream(d[n]).sum() % 1000000000);

    }
}
