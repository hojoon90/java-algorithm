package com.algorithm.recursion.boj;

import java.io.*;
import java.util.*;

public class BOJ_1074 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(func(N,r,c));

    }

    static int func(int N, int r, int c){
        if(N == 0) return 0;
        int half = 1<<(N-1);
        if(r < half && c < half) return func(N-1, r, c);
        if(r < half && c >= half) return half*half + func(N-1, r, c-half);
        if(r >= half && c < half) return 2*half*half + func(N-1, r-half, c);
        return 3*half*half + func(N-1, r-half, c-half);
    }
}
