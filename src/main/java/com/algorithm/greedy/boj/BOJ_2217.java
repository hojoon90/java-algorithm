package com.algorithm.greedy.boj;

import java.io.*;
import java.util.*;

public class BOJ_2217 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] w = new int[n];

        for (int i = 0; i < n; i++) {
            w[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(w);

        int result = 0;
        for (int i = 1; i <= n; i++) {
            result = Math.max(result, w[n-i]*i);
        }
        System.out.println(result);
    }

}

