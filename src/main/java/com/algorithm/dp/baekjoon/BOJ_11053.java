package com.algorithm.dp.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

/**
 * DP -> 최대한 중복 계산은 피해서 가자.
 * 계산 했던 값들은 다른 배열에 저장하자
 */
//https://www.acmicpc.net/problem/11053
public class BOJ_11053 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[] arr= new int[count+1];
        int[] dp = new int[count+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= count; i++) {
            arr[i] = Integer.parseInt(st.nextToken());  //arr에 수열 입력 받기
            dp[i] = 1;  //모든 dp값들은 최소 1
        }

        int max = 1;
        for (int i = 1; i <= count; i++) {
            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j]) dp[i] = Math.max(dp[i], dp[j]+1);
                // 이전 원소들 중 가장 큰 dp값 + 1
            }
            max = Math.max(max, dp[i]);  //LIS 길이 구하기
        }
        System.out.print(max);
    }


}
