package com.algorithm.dp.softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * DP로 해결하는 문제
 *
 * 문제 이해도 잘 안될뿐더러, 규칙이 잘 안찾아져 애를 먹은 문제
 * A라인과 B라인의 시간을 각각 비교한 후 걸리는 시간이 짧은 수를 선택해 라인을 계산해 나간다.
 * 짧은 시간을 구하는 것이므로 A/B라인을 넘나들며 가장 짧은 시간을 찾는다.
 * 그렇기에 A라인 기준 A,B를 비교한 케이스(totalTime[0][N])와 B라인 기준 A,B를 비교한 케이스(totalTime[1][N])의 시간을 모두 구해서
 * 그중 가장 짧은 시간을 구해주면 된다.
 *
 * 라인 변경 시 소요되는 시간배열도 별도 저장해주어야 하며, 시간을 모두 합산한 배열도 따로 저장해주어야 비교가 가능해진다.
 * 처음에는 배열 없이 += 식으로 시간을 계산하려 했지만, 정확한 계산이 이루어지지 않아 배열에 별도로 담아주었다.
 */
public class SfT_6287 {

    public static int[][] dp;
    public static int[][] switchLine;
    public static int[][] totalTime;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());

        dp = new int[2][count+1];
        switchLine = new int[2][count+1];
        totalTime = new int[2][count+1];
        for (int i = 1; i <= count; i++) {
            String[] lineTime = br.readLine().split(" ");
            dp[0][i] = Integer.parseInt(lineTime[0]);
            dp[1][i] = Integer.parseInt(lineTime[1]);
            //라인변경 시간
            if (lineTime.length > 2){
                switchLine[1][i] = Integer.parseInt(lineTime[2]);
                switchLine[0][i] = Integer.parseInt(lineTime[3]);
            }
        }

        totalTime[0][1] = dp[0][1];
        totalTime[1][1] = dp[1][1];

        for (int i = 2; i <= count; i++) {
            totalTime[0][i] = Math.min(totalTime[0][i-1], totalTime[1][i-1] + switchLine[0][i-1])+dp[0][i];
            totalTime[1][i] = Math.min(totalTime[1][i-1], totalTime[0][i-1] + switchLine[1][i-1])+dp[1][i];
        }

        System.out.println(Math.min(totalTime[0][count], totalTime[1][count]));

    }
}
