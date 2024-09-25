package com.algorithm.implementation.boj;

import java.io.*;
import java.util.*;

public class BOJ_1205 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        if(n == 0){
            System.out.println(1);
            return;
        }
        long point = Long.parseLong(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int rank = 1;
        long[] rankArr = new long[p];
        for (int i = 0; i < n; i++) {
            rankArr[i] = Long.parseLong(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            if(rankArr[i] > point) rank++;
        }

        if(n == p && rankArr[n-1] > point) rank = -1;

        System.out.println(rank);
    }

}