package com.algorithm.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCnt; i++) {
            long result = 0;
            long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            long N = arr[0]; // 시즌한정
            long M = arr[1]; // 일반

            long result1 = N/5;
            long result2 = N+M/12;

            result = (result1 <= result2) ? result1 : result2;

            System.out.println(result);

        }

    }
}
