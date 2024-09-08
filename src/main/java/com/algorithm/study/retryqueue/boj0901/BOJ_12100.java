package com.algorithm.study.retryqueue.boj0901;

import java.io.*;
import java.util.*;

/*
https://www.acmicpc.net/problem/12100
 */
public class BOJ_12100 {

    static int[][] board = new int[21][21];
    static int[][] board2 = new int[21][21];
    static int n;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] a = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(a[j]);
            }
        }
        int result = 0;

        for (int tmp = 0; tmp < Math.pow(4,5); tmp++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    board2[i][j] = board[i][j];
                }
            }

            int brute = tmp;
            for (int i = 0; i < 5; i++) {
                int dir = brute % 4;
                brute /= 4;
                tilted(dir);
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    result = Math.max(result, board2[i][j]);
                }
            }
        }
        System.out.println(result);
    }

    
    //기울여서 계산하는 로직
    static void tilted(int dir){
        while(dir != 0){
            rotate();
            dir--;
        }
        
        for (int i = 0; i < n; i++) {
            int[] tilted = new int[21];
            int idx = 0;
            for (int j = 0; j < n; j++) {
                if(board2[i][j] == 0) continue; 
                if(tilted[idx] == 0){
                    tilted[idx] = board2[i][j];
                }else if(tilted[idx] == board2[i][j]){
                    tilted[idx++] *= 2;
                }else{
                    tilted[++idx] = board2[i][j];
                }
            }
            
            for (int j = 0; j < n; j++) {
                board2[i][j] = tilted[j];
            }
        }
    }
    
    //회전 로직
    static void rotate(){
        int[][] tmp = new int[21][21];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tmp[i][j] = board2[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board2[i][j] = tmp[n-1-j][i];
            }
        }
        
    }

}
