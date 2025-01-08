package com.algorithm.implementation.boj;

import java.io.*;
import java.util.*;

public class BOJ_19941 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int answer = 0;

        char[] hpArr = br.readLine().toCharArray();
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(hpArr[i] == 'P'){
                int startIdx = Math.max(i-k, 0);
                int endIdx = Math.min(i+k, n-1);
                for(int j = startIdx; j <= endIdx; j++){
                    if(hpArr[j] == 'H' && !visited[j]){
                        answer++;
                        visited[j] = true;
                        break;
                    }

                }
            }
        }

        System.out.println(answer);

    }

}
