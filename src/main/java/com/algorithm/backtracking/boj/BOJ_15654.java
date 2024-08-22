package com.algorithm.backtracking.boj;

import java.io.*;
import java.util.*;

public class BOJ_15654 {

    static boolean[] isUsed = new boolean[10000];
    static int[] arr = new int[10];
    static int n;
    static int m;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        selected = new int[n];

        st = new StringTokenizer(br.readLine());
        int ln = st.countTokens();
        for(int i = 0; i < ln; i++){
            selected[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(selected);
        func(0);

        System.out.println(sb);

    }

    static void func(int k){
        if(k == m){
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            if(!isUsed[selected[i]]){
                arr[k] = selected[i];
                isUsed[selected[i]] = true;
                func(k+1);
                isUsed[selected[i]] = false;
            }
        }

    }
}
