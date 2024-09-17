package com.algorithm.study.retryqueue.retry01;

import java.io.*;
import java.util.*;

/*
https://www.acmicpc.net/problem/11053
 */
public class BOJ_11053 {
/*

    static int[] d = new int[1001];
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = i; j < n-1; j++) {
                if(arr[j + 1] >= arr[j]) cnt++;
            }
            d[i] = cnt;
        }

        int result  = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, d[i]);
        }

        System.out.println(result);

    }
*/
    static int[] d = new int[1005];

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            d[i+1] = 1;
        }

        int result = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if(arr[i-1] > arr[j-1]) {
                    d[i] = Math.max(d[i], d[j]+1);
                }
            }
            result = Math.max(result, d[i]);
        }

        System.out.println(result);
    }

}
