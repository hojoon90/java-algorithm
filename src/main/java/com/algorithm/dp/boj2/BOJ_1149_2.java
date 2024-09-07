package com.algorithm.dp.boj2;

import java.io.*;
import java.util.*;

public class BOJ_1149_2 {

    static int[][] d = new int[1005][3];
    static int[] R = new int[1005];
    static int[] G = new int[1005];
    static int[] B = new int[1005];

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        for (int i = 1; i <= cnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            R[i] = Integer.parseInt(st.nextToken());
            G[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }

        d[1][0] = R[1];
        d[1][1] = G[1];
        d[1][2] = B[1];

        for(int i = 2; i <= cnt; i++){
            d[i][0] = Math.min(d[i-1][1], d[i-1][2]) + R[i];
            d[i][1] = Math.min(d[i-1][0], d[i-1][2]) + G[i];
            d[i][2] = Math.min(d[i-1][0], d[i-1][1]) + B[i];
        }

        int result = Math.min(d[cnt][0], Math.min(d[cnt][1], d[cnt][2]));
        System.out.println(result);
    }

}
