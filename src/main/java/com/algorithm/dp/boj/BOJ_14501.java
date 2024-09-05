package com.algorithm.dp.boj;

import java.io.*;
import java.util.*;

public class BOJ_14501 {
    //실패코드
/*
    static int[] d = new int[20];

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Pair[] pair = new Pair[20];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            pair[i] = new Pair(t, p);
        }

        for (int i = 1; i <= n; i++) {
            Pair tmp = pair[i];
            int j = i + tmp.t;
            if(j >= n){
                continue;
            }
            d[i] = tmp.p;

            while(j <= n) {
                Pair ntmp = pair[j];
                j += ntmp.t;
                d[i] = d[i] + ntmp.p;
            }
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            result = Math.max(result, d[i]);
        }

        System.out.println(result);

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
    static int[] t = new int[20];
    static int[] p = new int[20];
    static int[] d = new int[20];

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = n; i >= 1; i--) {
            //i일자 + t[i]값이 마지막 일자보다 작거나 같을 때
            if(i + t[i] <= n + 1){

            }
        }

    }

}
