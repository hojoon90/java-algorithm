package com.algorithm.study.retryqueue.retry01;

import java.io.*;
import java.util.*;

/*
https://www.acmicpc.net/problem/11727
 */
public class BOJ_11727 {

    static int[] d = new int[1005];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        //d[n] = d[n-1] + d[n-2]
        // 만약 2x7 타일을 채워야 한다 했을 때, 2x1을 하나 채워두면 나머지 2x6을 채우는 방법의 수와 동일하다.
        // 마찬가지로 1x2를 2개 채워두면 나머지 2x5를 채우는 방법의 수와 동일하다.
        //2x2 타일도 결국은 d[n-2] 만큼 채워진다.
        //즉 d[n] = d[n-1] + d[n-2]*2

        d[1] = 1;
        d[2] = 3;
        for (int i = 3; i <= n; i++) {
            d[i] = (d[i-1] + 2 * d[i-2]) % 10007;
        }

        System.out.println(d[n] % 10007);
    }

}
