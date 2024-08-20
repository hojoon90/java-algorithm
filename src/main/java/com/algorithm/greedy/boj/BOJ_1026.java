package com.algorithm.greedy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/**
 * 난이도 낮은 그리디 문제.
 * 풀긴 풀었는데, B는 재정렬하면 안된다는 문제 의도와는 조금 다르게 된거 같긴 하지만...
 *
 * 결국은 A와 B를 곱한 수들을 합쳤을 때 가장 작은 수가 나오게 만들어주면 된다.
 * B는 움직이지 않는다고 가정하고 A를 재배치 하였을 때, 최솟값을 구하려면
 * A의 가장 큰 수가 B의 가장 작은 수를 곱해주면 된다.
 * 예시를 보면,
 * A: 1 1 1 6 0
 * B: 2 7 8 3 1
 * 를 재배열 했을 때
 * A: 1 1 0 1 6
 * B: 2 7 8 3 1
 * 위와 같이 정렬하여 식을 수행하면 된다.
 *
 * 그래서 A는 정방향 B는 역방항으로 정렬해준 뒤, 곱한 값들을 더하여 결과값을 출력하면 된다.
 */
//https://www.acmicpc.net/problem/1026
public class BOJ_1026 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        String[] aStr = br.readLine().split(" ");
        String[] bStr = br.readLine().split(" ");

        Integer[] A = new Integer[count];
        Integer[] B = new Integer[count];

        for (int i = 0; i < count; i++) {
            A[i] = Integer.parseInt(aStr[i]);
            B[i] = Integer.parseInt(bStr[i]);
        }

        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());

        int result = 0;
        for (int i = 0; i < count; i++) {
            result += A[i] * B[i];
        }

        System.out.println(result);
    }
}
