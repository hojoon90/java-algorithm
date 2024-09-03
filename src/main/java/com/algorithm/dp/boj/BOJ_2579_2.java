package com.algorithm.dp.boj;

import java.io.*;
import java.util.*;

public class BOJ_2579_2 {

    static int[][] dp = new int[301][3];
    static int[] score = new int[301];

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        for (int i = 1; i <= cnt; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        dp[1][1] = score[1];
        dp[1][2] = 0;   //2번 연속 올라서 첫번째 계단에 도달할 수 없다.
        dp[2][1] = score[2];
        dp[2][2] = score[1] + score[2];

        for (int i = 3; i <= cnt; i++) {
            dp[i][1] = Math.max(dp[i-2][1], dp[i-2][2]) + score[i];
            dp[i][2] = dp[i-1][1] + score[i];
        }

        System.out.println(Math.max(dp[cnt][1], dp[cnt][2]));
    }

}
