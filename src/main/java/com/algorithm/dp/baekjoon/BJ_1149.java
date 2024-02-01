package com.algorithm.dp.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 실패한 문제... 풀이집 보고 수정 필요
 * 문제를 잘못 생각했다. 색칠할 수 있는 최소 값을 구하는 문제인데 1번집에서 가장 작은 가격을 찾아 정하고 나서
 * 나머지 가격들을 찾다보니 제대로된 답이 나오지 않음.
 */
public class BJ_1149 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        int[][] dp = new int[count + 1][3];

        for (int i = 1; i <= count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int red = Integer.parseInt(st.nextToken());
            int green = Integer.parseInt(st.nextToken());
            int blue = Integer.parseInt(st.nextToken());

            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + red;
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + green;
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + blue;
        }
        System.out.println(Math.min(dp[count][0], Math.min(dp[count][1], dp[count][2])));

    }
}
