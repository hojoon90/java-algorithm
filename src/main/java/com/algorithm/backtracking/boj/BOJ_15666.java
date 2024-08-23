package com.algorithm.backtracking.boj;

import java.io.*;
import java.util.*;

public class BOJ_15666 {

    static int n;
    static int m;
    static int[] arr = new int[10];
    static int[] selected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[]args) throws IOException{

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
        int temp = 0;
        int st = 0;
        if(k != 0) st = arr[k - 1];
        for(int i = st; i < n; i++){
            if(selected[i] != temp){
                arr[k] = i;
                temp = selected[arr[k]];
                func(k+1);
            }
        }
    }

}
