package com.algorithm.dp.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * DP 문제 중 하나.
 * 아이디어만 참고하고 구현은 직접 진행하였다.
 * 문제는 1,2,3으로만 그 숫자를 나타낼 수 있는 모든 경우의 수를 구하는 것이다.
 * 먼저 n값은 11 미만인 수 이므로 11로 DP 배열을 초기화한다.
 * 1,2,3을 구할 수 있는 수를 먼저 세팅해준다. 1은 1하나, 2는 1+1,2 2개 3은 1+1+1, 2+1, 1+2, 3 4가지이다.
 * 그 후 4부터 10까지 구할 수 있는 경우의 수를 구해 배열에 넣어준다. 이때 규칙은 아래와 같다.
 *     예시로 4를 생각해보면, 3을 구할 수 있는 모든 경우의 수에 +1을 한 값이 4를 구할 수 있는 경우의 수이다.
 *        -> (1)+1+1+1, (1)+2+1, (1)+1+2, (1)+3 이렇게 4가지이다.
 *     마찬가지로 2를 구할수 있는 모든 경우의 수에 +2를 하면 4를 구할 수 있는 경우의 수이다.
 *        -> (2)+1+1, (2)+2
 *     마지막으로 1을 구할 수 있는 모든 경우의 수에 +3을 하면 4를 구할 수 있는 경우의 수이다.
 *        -> (3)+1
 *
 * 이 경우의 수를 모두 구하면 7이 나오게 된다. 점점 늘어나는 숫자들도 마찬가지 규칙으로 동작하게 된다.
 * 5 역시 4를 구할수 있는 모든 경우의 수에 +1을 하면 7개, 3을 구할 수 있는 경우의 수에 +2를 하면 4, 2를 구할 수 있는 모든 경우의 수에 +3을 하면 2 이므로
 * 7+4+2 로 13이 나오게 된다.
 *
 * DP는 규칙만 잘 찾으면 구현의 난이도가 어느정도 줄어드는 것 같다.
 */
//https://www.acmicpc.net/problem/9095
public class BJ_9095 {

    public static int[] dp = new int[11];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        int cnt = Integer.parseInt(br.readLine());
        for (int i = 4; i < 11; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        for (int i = 0; i < cnt; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]);
        }
    }

}
