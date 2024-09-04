package com.algorithm.dp.boj;

import java.io.*;
import java.util.*;

public class BOJ_1932_2 {

    static int[][] d = new int [501][501];

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        d[1][1] = Integer.parseInt(br.readLine());
        for (int i = 2; i <= n; i++) {
            String[] sArr = br.readLine().split(" ");
            for (int j = 1; j <= sArr.length; j++) {
                d[i][j] = Math.max(d[i-1][j-1], d[i-1][j]) + Integer.parseInt(sArr[j-1]);
            }
        }

        int[] resultArr = d[n];
        int result = 0;

        for (int i = 1; i <= n; i++) {
            result = Math.max(result, resultArr[i]);
        }
        System.out.println(result);

    }

}
