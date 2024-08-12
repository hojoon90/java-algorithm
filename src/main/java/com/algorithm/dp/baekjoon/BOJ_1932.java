package com.algorithm.dp.baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1932 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        //초기화 시 0으로 모두 채워짐.
        int[][] triangle = new int[count+1][count+1];
        int[][] dp = new int[count+1][count+1];

        for(int i = 1; i <= count; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= i; j++){
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //비교는 본인자리 위의 값과 본인자리 왼쪽 위의 값(-1,-1한 값)을 비교해서 더 큰 값과 본인값을 더한다.
        for(int i = 1; i<= count; i++){
            for(int j = 1; j<= count; j++){
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + triangle[i][j];
            }
        }
        int result = 0;

        //마지막에 제일 큰 수만 찾아서 출력
        for(int i = 1; i <= count; i++){
            if(result < dp[count][i]) result = dp[count][i];
        }

        System.out.println(result);

    }

}
