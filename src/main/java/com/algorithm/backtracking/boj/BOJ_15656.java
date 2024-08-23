package com.algorithm.backtracking.boj;

import java.io.*;
import java.util.*;

public class BOJ_15656 {

    static int n;
    static int m;
    static int[] selected;
    static int[] arr = new int[10];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        selected = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            selected[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(selected);
        func(0);
        System.out.println(sb);

    }

    static void func(int k){
        if(k == m){
            for(int i = 0; i < m; i++){
                sb.append(selected[arr[i]]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < n; i++){
            arr[k] = i;
            func(k+1);
        }
    }

}
