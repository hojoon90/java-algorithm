package com.algorithm.greedy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 널빤지 깔기 그리디문제
 * 먼저 웅덩이를 정렬해주는게 중요하다. 웅덩이 위치를 배열에 넣어주고, 정렬을 해준다. 정렬이 끝나면 반복문을 돌리는데,
 * 시작점이 웅덩이 시작 좌표보다 낮으면 시작점으로 잡아준다. 그리고 시작점이 끝점보다 클때까지 널빤지 범위만큼 깔아주고 널빤지 카운트를 올려준다.
 * 마지막까지 다 돌리고 나면 널빤지를 깔고 난 카운트를 출력해준다.
 */
public class BOJ_1911 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] pool = new int[n][2];
        for (int i = 0; i < n; i++) {
            int[] startEnd = new int[2];
            st = new StringTokenizer(br.readLine());
            startEnd[0] = Integer.parseInt(st.nextToken());    //웅덩이 시작지점
            startEnd[1] = Integer.parseInt(st.nextToken());    //웅덩이 종료지점
            pool[i] = startEnd;
        }

        System.out.println(solution(pool, m));

    }

    public static int solution(int[][] n, int m) {

        int answer = 0;
        int range = 0;

        // 웅덩이를 정렬시켜준다.
        Arrays.sort(n, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });

        // 웅덩이를 순회하면서 널빤지를 깔아준다.
        for (int[] ints : n) {
            if (ints[0] > range) {
                range = ints[0];
            }

            if (ints[1] > range) {
                while (ints[1] > range) {
                    range += m;
                    answer++;
                }
            }
        }

        return answer;
    }
}
