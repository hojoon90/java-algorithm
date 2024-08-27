package com.algorithm.simulation;

import java.io.*;
import java.util.*;

public class BOJ_12100 {

    static int n;
    static int[][] board = new int[21][21];
    static int[][] board2 = new int[21][21];


    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] data = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(data[j]);
            }
        }

        int result = 0;
        for (int tmp = 0; tmp < 1024; tmp++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    board2[i][j] = board[i][j];
                }
            }
            int brute = tmp;
            for (int i = 0; i < 5; i++) {
                int dir =  brute % 4;
                brute /= 4;
                tilt(dir);
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    result = Math.max(result, board2[i][j]);
                }
            }
        }
        System.out.println(result);

    }

    private static void tilt(int dir) {
        while(dir != 0) {
            rotate();
            dir--;
        }
        for(int i = 0; i < n; i++){
            int[] tilted = new int[21];
            int idx = 0;
            for (int j = 0; j < n; j++) {
                if(board2[i][j] == 0) continue;
                if(tilted[idx] == 0) {
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

    private static void rotate(){
        int[][] temp = new int[21][21];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = board2[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board2[i][j] = temp[n-1-j][i];
            }
        }
    }

}
