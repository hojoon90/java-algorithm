package com.algorithm.study.retryqueue.retry01;

import java.io.*;
import java.util.*;

/*
https://www.acmicpc.net/problem/14501
*/
public class BOJ_14501{
/*

    static int[] d = new int[20];

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Pair[] arr = new Pair[n+1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            arr[i] = new Pair(t, p);
        }


        for (int i = n; i >= 1; i--) {
            Pair p = arr[i];
            if(p.t + i <= n){   //날짜를 넘지 않으면 가격을 추가한다.
                d[i] += p.p;
                int j = i;
                while(j <= n){
                    Pair pair = arr[j];
                    if(pair.t + j <= n){
                        d[i] += pair.p;
                    }
                    j += p.t;
                }
            }
        }

    }

    static class Pair{
        int t;
        int p;

        public Pair(int t, int p) {
            this.t = t;
            this.p = p;
        }
    }
*/

    static int[] d = new int[20];
    static int[] t = new int[20];
    static int[] p = new int[20];

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = n; i >= 1; i--) {
            if(i + t[i] <= n + 1) { // n+1을 하는 이유는 다음날짜 처리를 위해..? 7일차에 1일 걸리는 업무면 7일까지는 할 수 있으므로..?
                d[i] = Math.max(d[i + t[i]] + p[i], d[i + 1]);
            }else{
                d[i] = d[i + 1];
            }
        }

        int result = d[1];
        for (int i = 1; i <= n; i++) {
            result = Math.max(result, d[i]);
        }

        System.out.println(result);

    }

}
