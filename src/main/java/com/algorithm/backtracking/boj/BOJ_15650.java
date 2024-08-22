package com.algorithm.backtracking.boj;

import java.io.*;
import java.util.*;

public class BOJ_15650 {

    static StringBuilder sb = new StringBuilder();
    static int[] resultArr = new int[10];
    static boolean[] isUsed = new boolean[10];
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

//        func(0, 0);
        func2(0);
        System.out.println(sb);
    }

    static void func(int k, int prev){
        if(k == m){
            for(int i = 0; i < m; i++){
                int result = resultArr[i];
                sb.append(result).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            if(!isUsed[i] && i > prev){
                resultArr[k] = i;
                isUsed[i] = true;
                func(k+1, i);   //값 비교를 위해 i 도 넘겨준다
                isUsed[i] = false;
            }
        }
    }

    static void func2(int k){
        if(k == m){
            for (int i = 0; i < m; i++) {
                sb.append(resultArr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        int st = 1;
        if(k != 0) st = resultArr[k-1] + 1;
        for (int i = st; i <= n; i++) {
            if(!isUsed[i]){
                resultArr[k] = i;
                isUsed[i] = true;
                func2(k+1);
                isUsed[i] = false;
            }
        }
    }


}
