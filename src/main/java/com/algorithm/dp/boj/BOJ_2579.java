package com.algorithm.dp.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 계단을 오를수 있는 케이스를 찾는다.
 * 그 후 두 방법 중 가장 큰 수를 찾아서 추가해준다.
 * 처음 계단 올라가는 값만 미리 계산한다.
 */
//https://www.acmicpc.net/problem/2579
public class BOJ_2579 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());
        int[] dp = new int[301];
        int[] score = new int[301];

        for (int i = 1; i < cnt; i++) {
            dp[i] = Integer.parseInt(br.readLine());
        }

        //처음 시작 부분의 계단들의 점수들만 처리해둔다.
        score[1] = dp[1];
        score[2] = dp[1] + dp[2];
        score[3] = Math.max(dp[1], dp[2]) + dp[3];

        for (int i = 4; i < cnt; i++) {
            score[i] = Math.max(score[i-3] + dp[i-1], score[i-2]) + dp[i];
        }

        System.out.println(score[cnt]);

    }


}
