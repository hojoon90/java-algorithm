package com.algorithm.dp.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * DP 피보나치를 이용한 문제
 * 먼저 규칙을 찾아보려 노력했다. 규칙 찾고 확인만 한 10분 걸린 것 같다.
 * 찾은 규칙은 타일을 놓을 수 있는 경우의 수는 피보나치 규칙으로 늘어난다는 것을 알 수 있었다.
 * 그래서 타일이 없을때와 1개일때는 1로 세팅해주고 피보나치로 값을 초기화 해주었다.
 * 사실 이렇게 푸는게 맞나 싶지만.. 주어진 카운트만큼 for문을 돌리면서 피보나치 수로 세팅을 해주고, 해당 카운트의 피보나치 값을 가져왔다.
 * 다만 수를 10007로 나눈 나머지 값을 넣어줘야 하기 때문에 배열 저장 시 % 10007을 추가해주었다.
 * 난이도에비해 생각보다... 간단하게 풀린 문제?
 */
//https://www.acmicpc.net/problem/11726
public class BJ_11726 {

    public static int[] dp = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());
        dp[0] = 1; //dp 초기화
        dp[1] = 1; //dp 초기화
        for (int i = 2; i <= cnt; i++) {
            dp[i] = (dp[i-2] + dp[i-1])%10007;
        }

        System.out.println(dp[cnt]);
    }

}
