package com.algorithm.backtracking.boj;

import java.io.*;
import java.util.*;

public class BOJ_15651 {

    static int n;
    static int m;
    static int[] arr = new int[7];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        func(0);
        System.out.println(sb);
    }

    static void func(int k){
        if (k == m){
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            arr[k] = i;
            func(k+1);
        }
    }

}
