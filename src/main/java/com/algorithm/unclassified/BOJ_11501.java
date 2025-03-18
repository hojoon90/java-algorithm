package com.algorithm.unclassified;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11501 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int t = 0; t < n; t++) {
            int day = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int money = 0;
            int max = 0;
            for(int i = day-1; i >= 0; i--) {
                max = Math.max(arr[i], max);
                money += max - arr[i];
            }
            System.out.println(money);

        }

    }

}
