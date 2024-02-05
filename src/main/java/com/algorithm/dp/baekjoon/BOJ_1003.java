package com.algorithm.dp.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 피보나치 수열 응용 문제
 * 규칙을 확실하게 파악하지 못해서 제대로 풀지 못했다.
 * 해결방안만 보고 나름대로 구현은 해보았는데... 맞는 방법인지는 모르겠다.
 * 일단 규칙은 피보나치 수열 그 자체가 규칙이다.
 * 0이 출력되는 경우와 1이 출력되는 경우는 아래 처럼 늘어나게 된다.
 * (1, 0) (0, 1) (1, 1), (1, 2), (2, 3), (3, 5) (5, 8), (8, 13), (13, 21)....
 * 이렇게 0 과 1 출력 결과 모두 피보나치 수열로 올라가게 된다.
 * 그렇기에 출력은 테스트 케이스가 0으로 넘어올 경우만 (1, 0)으로 노출해주고, 나머지 값은 (dp[n-1], dp[n])으로 출력해주면 된다.
 * 그리고 피보나치를 모두 계산하면 비효율적이므로 계산된 값은 dp배열에 넣어준다.
 */
//https://www.acmicpc.net/problem/1003
public class BOJ_1003 {

    public static long[] dp = new long[41];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int num = Integer.parseInt(br.readLine());
            dp[num] = fibonacci(num);

            if(num == 0) System.out.println("1 0");
            else System.out.println(dp[num-1]+" "+dp[num]);
        }

    }

    public static long fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }else if (dp[n] != 0) {
            return dp[n];
        }else {
            dp[n-1] = fibonacci(n-1);
            dp[n-2] = fibonacci(n-2);
            return dp[n - 1] + dp[n - 2];
        }
    }


}
