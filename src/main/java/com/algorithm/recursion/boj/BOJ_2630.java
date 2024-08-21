package com.algorithm.recursion.boj;

import java.io.*;
import java.util.*;

public class BOJ_2630 {

    static long[][] paper = new long[16400][16400];
    static int[] paperCnt = new int[2];

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        for(int i = 0; i < count; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < count; j++){
                paper[i][j] = Long.parseLong(st.nextToken());
            }
        }

        func(0, 0, count);
        for (int i: paperCnt){
            System.out.println(i);
        }

    }

    static boolean check(int x, int y, int n){

        for (int i = x; i < x+n; i++) {
            for (int j = y; j < y+n; j++) {
                if(paper[i][j] != paper[x][y]){
                    return false;
                }
            }
        }
        return true;
    }


    static void func(int x, int y, int n){
        if(check(x, y, n)){
            paperCnt[Long.valueOf(paper[x][y]).intValue()] += 1;
            return;
        }
        int half = n/2;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                func(x + i*half, y + j*half, half);
            }
        }

    }


}
