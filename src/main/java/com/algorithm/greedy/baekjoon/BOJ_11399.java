package com.algorithm.greedy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 가장 최단 시간을 구하는 문제
 * 문제 자체는 그렇게 크게 어렵지 않았고, 풀이 역시 어렵지 않았다.
 * 두 단계로 나눌수 있으며, 먼저 분을 작은 수 부터 정렬하여 가장 최단기로 기다리는 시간을 만들 수 있게 해준다.
 * 그리고 난 후 결과값에 앞에서 기다린 시간 수를 계속 더해주면 된다.
 * 나는 stream을 이용하여 limit으로 앞에서 기다린 수들을 모두 더한 값을 차례로 result에 더해주었다.
 * 만약 stream을 사용하지 않는다면 prev라는 변수를 세팅해주고, 거기에 지금까지 걸린 시간을 누적시켜주면 된다.
 */
//https://www.acmicpc.net/problem/11399
public class BOJ_11399 {
    public static int[] minuteArr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        minuteArr = new int[count];
        int result = 0;
        StringTokenizer tk = new StringTokenizer(br.readLine());
        for (int i = 0; i < count; i++) {
            int minute = Integer.parseInt(tk.nextToken());
            minuteArr[i] = minute;
        }
        Arrays.sort(minuteArr);

        for (int i = 1; i <= count; i++) {
            int sum = Arrays.stream(minuteArr).limit(i).sum();
            result += sum;
        }

        System.out.println(result);
    }
}
