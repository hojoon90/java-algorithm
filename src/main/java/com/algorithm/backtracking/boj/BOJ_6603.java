package com.algorithm.backtracking.boj;

import java.io.*;
import java.util.*;

public class BOJ_6603 {

    static int[] selected;
    static int n;
    static int m;
    static int[] arr = new int[6];
    static boolean[] isUsed = new boolean[50];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String tmp = br.readLine();
            if("0".equals(tmp)) break;
            StringTokenizer st = new StringTokenizer(tmp);
            n = Integer.parseInt(st.nextToken());
            m = 6;

            selected = new int[n];
            for (int i = 0; i < n; i++) {
                selected[i] = Integer.parseInt(st.nextToken());
            }
            func(0);
            System.out.println(sb);
            sb = new StringBuilder();

        }


    }
    static void func(int k){
        if(k == m){
            for(int i = 0; i < m; i++){
                sb.append(selected[arr[i]]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int st = 0;
        if(k != 0) st = arr[k-1] + 1;
        for(int i = st; i < n; i++){
            if(!isUsed[i]){
                arr[k] = i;
                isUsed[i] = true;
                func(k+1);
                isUsed[i] = false;
            }
        }

    }

}
