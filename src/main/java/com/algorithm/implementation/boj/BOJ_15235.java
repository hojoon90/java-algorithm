package com.algorithm.implementation.boj;

import java.io.*;
import java.util.*;

public class BOJ_15235 {

    static int[] timeArr;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        timeArr = new int[n];

        int[] pzArr = new int[n];
        int separateCnt = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++){
            int tmp = Integer.parseInt(st.nextToken());
            pzArr[i] = tmp;
            separateCnt += tmp;
        }

        int idx = 1;
        for(int i = 1; i <= separateCnt; i++){
            for(int j = 0; j < n; j++){
                if(pzArr[j] == 0) continue;
                timeArr[j] = idx;
                pzArr[j]-=1;
                idx++;
            }
        }

        for(int time:timeArr){
            System.out.print(time+" ");
        }

    }

}
