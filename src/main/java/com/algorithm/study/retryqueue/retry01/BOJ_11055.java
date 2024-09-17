package com.algorithm.study.retryqueue.retry01;

import java.io.*;
import java.util.*;

/*
https://www.acmicpc.net/problem/11055
 */
public class BOJ_11055 {
/*

    static int[] d = new int[1005];

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if(a[j-1] < a[i-1]){
                    d[i] += a[j-1];
                }
            }
            d[i] += a[i-1];
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            result = Math.max(result, d[i]);
        }

        System.out.println(result);
    }
*/
    static int[] d = new int[1005];
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n+1];

        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(st.nextToken());
            a[i] = val;
            d[i] = val;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if(a[i] > a[j]) d[i] = Math.max(d[i], a[i]+d[j]);
            }
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            result = Math.max(result, d[i]);
        }
        System.out.println(result);
    }

}
