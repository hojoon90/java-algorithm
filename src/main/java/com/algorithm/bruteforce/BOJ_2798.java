package com.algorithm.bruteforce;

import java.io.*;
import java.util.*;

public class BOJ_2798 {

    static int n, m, result;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        result = 0;

        int[] arr = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for(int i = 0; i <= n - 3; i++){
            findNum(i, sum, 1, arr);
        }

        System.out.println(result);
    }

    public static void findNum(int startNum, int sum, int cnt, int[] arr){
        if(cnt > 3){
            if(sum <= m){
                result = Math.max(sum, result);
            }
            return;
        }
        for(int i = startNum; i < n; i++){
            if(visited[i]) continue;
            sum += arr[i];
            visited[i] = true;
            cnt++;
            findNum(i, sum, cnt, arr);
            sum -= arr[i];
            visited[i] = false;
            cnt--;
        }
    }

}
