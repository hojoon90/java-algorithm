package com.algorithm.greedy.boj2;

import java.io.*;
import java.util.*;

public class BOJ_11047_2 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[10];

        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int result = 0;
        if(k == 0) {
            System.out.println(result);
            return;
        }

        for (int i = 9; i >= 0; i--) {
            int coinCnt = k / coins[i];
            result += coinCnt;
            k = k % coins[i];
            if(k == 0) break;
        }

        System.out.println(result);

    }

}
