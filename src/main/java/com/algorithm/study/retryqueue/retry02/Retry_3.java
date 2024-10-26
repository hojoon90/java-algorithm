package com.algorithm.study.retryqueue.retry02;

import java.io.*;

/*
https://www.acmicpc.net/problem/12100
 */
public class Retry_3 {

    static int[][] board = new int[21][21];
    static int[][] board2 = new int[21][21];
    static int n;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(s[j]);
            }
        }

        int mx = 0;
        //4방향을 5번씩 돌리므로 4^5
        for(int tmp = 0; tmp < 1024; tmp++){
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    board2[i][j] = board[i][j];
                }
            }
            int brute = tmp;
            for (int i = 0; i < 5; i++) {
                int dir = brute % 4;
                brute /= 4;
                tilt(dir);
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mx = Math.max(mx, board2[i][j]);
                }
            }
        }
        System.out.println(mx);
    }

    private static void rotate() {
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

    static void tilt(int dir) {
/* O(n^2) 시간복잡도
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0) continue;
            if(result[0] == 0){
                result[0] = arr[i];
                continue;
            }

            int idx = i;
            while(result[idx] == 0) idx--;

            if(!merged[idx] && result[idx] == arr[i]) {
                result[idx] *= 2;
                merged[idx] = true;
            }else{
                result[idx+1] = arr[i];
            }
        }
*/
        while(dir!=0){
            rotate();
            dir--;
        }
        //O(n) 시간복잡도
        for (int i = 0; i < n; i++) {
            int[] tilted = new int[21];
            int idx = 0;
            for (int j = 0; j < n; j++) {
                if(board2[i][j] == 0) continue;
                if(tilted[idx] == 0) {
                    tilted[idx] = board2[i][j];
                }else if(tilted[idx] == board2[i][j]){
                    tilted[idx++] *= 2;
                }else {
                    tilted[++idx] = board2[i][j];
                }
            }
            for (int j = 0; j < n; j++) {
                board2[i][j] = tilted[j];
            }
        }
    }

}
