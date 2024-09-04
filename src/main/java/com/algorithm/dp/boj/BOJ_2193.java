package com.algorithm.dp.boj;

import java.io.*;
import java.util.*;

public class BOJ_2193 {

    static long[] d = new long[100];

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        d[1] = 1;
        d[2] = 1;

        for (int i = 3; i <= n; i++) {
            d[i] = d[i-1] + d[i-2];
        }

        System.out.println(d[n]);

    }

}
