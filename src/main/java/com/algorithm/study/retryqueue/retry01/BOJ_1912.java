package com.algorithm.study.retryqueue.retry01;

import java.io.*;
import java.util.*;

/*
https://www.acmicpc.net/problem/1912
 */
public class BOJ_1912 {
/*

    static int[] d = new int[100000];

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        int[] nArr = new int[cnt];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cnt; i++) {
            nArr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;

        for (int i = 0; i < cnt; i++) {
            int sum = 0;
            int num = 0;
            for (int j = i; j < cnt; j++) {
                num += nArr[j];
            }
            sum = Math.max(sum, sum + num);
            d[i] = sum;
        }


        for (int i = 0; i < cnt; i++) {
            result = Math.max(result, d[i]);
        }

        System.out.println(result);
    }
*/
    static int[] d = new int[100005];

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        int[] arr = new int[cnt];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < cnt; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        d[1] = arr[0];
        int result = d[1];

        for(int i = 2; i <= cnt; i++){
            if(d[i-1] + arr[i-1] >= arr[i-1]){
                d[i] = d[i-1] + arr[i-1];
            }else{
                d[i] = arr[i-1];
            }
        }

        for (int i = 1; i <= cnt; i++) {
            result = Math.max(result, d[i]);
        }

        System.out.println(result);
    }


}
