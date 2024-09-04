package com.algorithm.dp.boj;

import java.io.*;
import java.util.*;

public class BOJ_11727 {

    static int[] d = new int[1005];

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        d[1] = 1;
        d[2] = 3;   // 2x1 2개 / 2x2 1개의 2가지 방법이 있으므로 d[2]는 3
        for (int i = 3; i <= n; i++) {
            d[i] = (d[i-1] + 2 * d[i-2]) % 10007;   //i-2는 2x1, 2x2 두가지 방법으로 처리하므로 2를 곱해준다.
        }

        System.out.println(d[n]);
    }
}
