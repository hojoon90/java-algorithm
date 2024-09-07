package com.algorithm.greedy.boj;

import java.io.*;
import java.util.*;

public class BOJ_11501 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int test = 0; test < t; test++) {
            int n = Integer.parseInt(br.readLine());
            int a[] = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            int max = a[n-1];
            long result = 0;
            for (int i = n-2; i >= 0 ; i--) {
                if(a[i] > max) max = a[i];
                result += max - a[i];
            }


            System.out.println(result);
        }

    }

}
