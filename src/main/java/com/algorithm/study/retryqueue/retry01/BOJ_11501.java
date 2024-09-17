package com.algorithm.study.retryqueue.retry01;

import java.io.*;
import java.util.*;

/*
https://www.acmicpc.net/problem/11501
 */
public class BOJ_11501 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = Integer.parseInt(st.nextToken());
            }

            long price = 0;
            int mx = 0;
            for (int j = n-1; j >= 0; j--) {
                mx = Math.max(mx, a[j]);
                price += mx - a[j];
            }

            System.out.println(price);

        }


    }

}
