package com.algorithm.dp.boj;

import java.io.*;
import java.util.*;

public class BOJ_11055 {

    static int[] d = new int[1005];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[1005];

        String[] s = br.readLine().split(" ");
        for (int i = 0; i < s.length; i++) {
            a[i] = Integer.parseInt(s[i]);
            d[i] = a[i];
        }

        //d[i] = Math.max(d[i], d[j]+a[j]);
        d[0] = a[0];
        int mx = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if(a[i] > a[j]) d[i] = Math.max(d[i], d[j] + a[i]);
            }
        }

        for (int i = 0; i < n; i++) {
            mx = Math.max(mx, d[i]);
        }
        System.out.println(mx);
    }

}
