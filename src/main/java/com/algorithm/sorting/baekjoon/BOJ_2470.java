package com.algorithm.sorting.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 정렬 후 투포인터 비교 문제.
 *
 * 투포인터 문제는 처음 해봐서 내 힘으로 풀지는 못했다...
 * 요점은 정렬 후 양 끝에 포인터를 두고 서로 숫자를 비교해가면서 인덱스를 옮겨주는데 있다.
 * 왼쪽과 오른쪽 수를 더해 가장 최솟값인 두 수를 구해주면 되는 문제이다.
 * 기본적으로는 왼쪽인덱스를 이동하며, 만약 두 수를 더했을 때 양수가 나오면 오른쪽 인덱스를 왼쪽으로 옮겨 조금 더 작은수로 비교를 한다.
 * 그렇게 비교한 후 가장 작은 값을 낼 수 있는 두 수를 출력해주면 된다.
 * 투포인터 비교만 잘 알고 있으면 풀 수 있는 문제.
 */
public class BOJ_2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        String[] strArr = br.readLine().split(" ");
        int[] numArr = new int[count];
        for (int i = 0; i < count; i++) {
            numArr[i] = Integer.parseInt(strArr[i]);
        }

        Arrays.sort(numArr);
        int result = Integer.MAX_VALUE;
        int leftIdx = 0;
        int rightIdx = count - 1;
        int ans1 = 0;
        int ans2 = 0;
        while (leftIdx < rightIdx) {
            int sum = numArr[leftIdx] + numArr[rightIdx];
            int i = Math.abs(sum);
            if (i < result) {
                result = i;
                ans1 = numArr[leftIdx];
                ans2 = numArr[rightIdx];
            }
            if (sum > 0) {
                rightIdx--;
            } else {
                leftIdx++;
            }
        }
        System.out.println(ans1 + " " + ans2);
    }
}
