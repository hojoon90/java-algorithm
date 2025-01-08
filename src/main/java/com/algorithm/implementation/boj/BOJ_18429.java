package com.algorithm.implementation.boj;

import java.io.*;
import java.util.*;

public class BOJ_18429 {

    static int n, k, ans;
    static boolean[] visited;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[n];
        ans = 0;
        calc(0, 500);
        System.out.println(ans);
    }

    public static void calc(int day, int weight){
        if(day == n){
            ans++;
            return;
        }

        for(int i = 0; i < n; i++){
            if(!visited[i] && (weight + arr[i] - k) >= 500) {
                visited[i] = true;
                calc(day + 1, weight + arr[i] - k);
                visited[i] = false;
            }
        }
    }


}
