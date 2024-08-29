package com.algorithm.sorting.boj;

import java.io.*;
import java.util.*;

public class BOJ_11728 {


    public static void main(String[] args) throws IOException{

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] aArr = new int[n];
        int[] bArr = new int[m];

        String[] aStr = br.readLine().split(" ");
        String[] bStr = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            aArr[i] = Integer.parseInt(aStr[i]);
        }
        for (int i = 0; i < m; i++) {
            bArr[i] = Integer.parseInt(bStr[i]);
        }

        int aIdx = 0;
        int bIdx = 0;

        for (int i = 0; i < n+m; i++) {
            if(n == aIdx) sb.append(bArr[bIdx++]).append(" ");
            else if(m == bIdx) sb.append(aArr[aIdx++]).append(" ");
            else if(aArr[aIdx] < bArr[bIdx]) sb.append(aArr[aIdx++]).append(" ");
            else sb.append(bArr[bIdx++]).append(" ");
        }

        System.out.println(sb);

    }

}
