package com.algorithm.dp.softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * dp.. 다이나믹 프로그래밍으로 처리하는 것 같다.
 * DP에 대해서는 좀 더 공부해야겠지만 일단 이해한 수준으로만 작성한다.
 * 핵심은 현재 밟고 있는 돌을 기준으로 몇개를 밟고 왔는지 카운트를 세어주면 된다.
 * 그렇게 카운트한 값은 dp 배열에 넣어준다.
 * 그럴려면 현재 돌을 기준으로 하여 몇개 돌을 밟고 왔는지 계산하여 배열에 넣을 수 있고,
 * 그렇게 넣은 배열에서 최대한 많이 밟고 온 카운트를 얻을 수 있다.
 */
//https://softeer.ai/practice/6293
public class SfT_6293 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int stoneCnt = Integer.parseInt(br.readLine());
        String[] stonesStr = br.readLine().split(" ");
        int[] stones = new int[stoneCnt];
        int[] dp = new int[stoneCnt];
        int resultCnt = 0;

        for (int i = 0; i < stoneCnt; i++) {
            stones[i] = Integer.parseInt(stonesStr[i]);
            dp[i] = 1;
        }

        for (int i = 0; i < stoneCnt; i++) {
            for (int j = 0; j < i; j++) {
                if(stones[j] < stones[i]){ // 지나온 돌이 현재 돌보다 크기가 작으면 카운트 추가.
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        for (int i: dp) {
            resultCnt = Math.max(i, resultCnt);
        }

        System.out.println(resultCnt);
    }
}
