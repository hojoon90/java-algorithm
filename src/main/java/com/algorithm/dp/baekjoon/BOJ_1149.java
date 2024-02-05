package com.algorithm.dp.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 실패한 문제... 풀이집 보고 수정 필요
 * 문제를 잘못 생각했다. 색칠할 수 있는 최소 값을 구하는 문제인데 1번집에서 가장 작은 가격을 찾아 정하고 나서
 * 나머지 가격들을 찾다보니 제대로된 답이 나오지 않음.
 * 현재 색상 가격과, 전에 세팅된 가격 중 현재 색을 제외한 나머지 색상의 가격중 가작 작은 값을 선택해서 더한다.
 * 이렇게 count 개수까지 배열을 돌면서 선택될 수 있는 모든 경우의 가격을 구한다.
 * 이 중 가장 작은 가격을 찾아서 출력해준다.
 * <p>
 * 이런 2중 배열을 사용할수 있는 경우는 최대한 2중배열을 이용해서 처리해주어야 할 것 같다.
 * 그리고 모든 길찾기 혹은 모든 케이스 찾기와 같은 문제 유형에 약하다는것도 이번에 깨달았다.
 * 해당 문제들을 좀 더 연습해봐야 할 것 같다.
 */
//https://www.acmicpc.net/problem/1149
public class BOJ_1149 {

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
