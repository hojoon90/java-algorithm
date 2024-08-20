package com.algorithm.dp.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * DP 문제.
 * DP는 강의를 한번 보고 풀어봤지만 뭔가 개념이 완벽하게 잡히지 않는다.. 문제를 좀 더 여러번 풀어봐야 할 듯 하다.
 * 일단 이해한 내용들로만 보면 DP의 핵심은 '한번 해결한 문제는 다시 해결하지 않는다.'이다.
 * 아래 문제는 최대 100만까지의 연산 횟수의 계산을 dp 배열안에 모두 넣어둔다.
 * 배열에 1000001을 넣는 이유는 1부터 백만까지 1로 만들때 필요한 연산수를 모두 담아두기 위함이다. (배열의 시작은 0이기 때문)
 * x로 받은 수 만큼 배열을 돌리면서 숫자를 1로 만드는 연산 횟수를 각 배열에 저장한다.
 *
 * 반복문 안에서 +1은 1을 빼는것에 대한 '계산 카운트'를 올려준다
 * 일단 무조건 숫자의 계산 카운트에서 +1을 해주고 아래 나누기 계산을 들어간다.(-1에 대한 계산을 일단 무조건 하는것이다.)
 * 10을 기준으로 한다면 계산 방법엔 2가지가 있다.
 * 10 - 5 - 4 - 2 - 1 (네번)
 * 10 - 9 - 3 -1 (세번)
 *
 * 세번만에 1을 만드는 계산을 하려면 10에서 1을 먼저 빼고, 9를 3으로 2번 나눠주면 된다.
 * 그러므로 기존 9의 계산카운트 값인 2 에서 -1을 처리한 카운트 +1을 해주면 된다. (즉 10-1에 대한 카운트를 올려준다.)
 * 그리고 나서 10은 2로 나뉠 수 있으니 if(i % 2 == 0)를 탄다. 그럼 i값 10은 2로 나눈 몫에 해당하는 계산 카운트를 가져온다.
 * 여기서는 5일때 1을 만드는 계산카운트를 가져온다. 이때도 +1을 하는데, 이때는 10에서 2를 나눈거에 대한 계산카운트를 올려준다.
 * 그렇기에 5에서 1을 만드는 계산 카운드 3 + 10에서 5를 만든 계산 카운트 1을 더해서 총 4가 되는 것이다.
 * 둘 중 3이 제일 작기 때문에 min 함수를 통해 3이 나오는 것이다.
 */
//https://www.acmicpc.net/problem/1463
public class BOJ_1463 {
    public static int[] dp = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());

        for (int i = 2; i <= x; i++) {
            dp[i] = dp[i - 1] + 1;  // -1에 대한 계산 카운트를 올린다.

            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2]+1);
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3]+1);
            }

        }
        System.out.println(dp[x]);
    }

}
