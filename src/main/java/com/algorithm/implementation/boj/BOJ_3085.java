package com.algorithm.implementation.boj;

import java.io.*;
import java.util.*;

public class BOJ_3085 {

    static char[][] board;
    static int answer;
    static int n;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        answer = 0;
        n = Integer.parseInt(br.readLine());
        board = new char[n][n];

        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < n; j++){
                board[i][j] = s.charAt(j);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n-1; j++){
                swap(i, j, i, j+1);
                search();
                swap(i, j+1, i, j);
            }
        }

        for(int i = 0; i < n-1; i++){
            for(int j = 0; j < n; j++){
                swap(i, j, i+1, j);
                search();
                swap(i+1, j, i, j);
            }
        }

        System.out.println(answer);
    }

    public static void swap(int x1, int y1, int x2, int y2){
        char tmp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = tmp;
    }

    public static void search(){
        for(int i = 0; i < n; i++){
            int cnt = 1;
            for(int j = 0; j < n-1; j++){
                if(board[i][j] == board[i][j+1]){
                    cnt++;
                    answer = Math.max(answer, cnt);
                }else{
                    cnt = 1;
                }
            }
        }

        for(int j = 0; j < n; j++){
            int cnt = 1;
            for(int i = 0; i < n -1; i++){
                if(board[i][j] == board[i+1][j]){
                    cnt++;
                    answer = Math.max(answer, cnt);
                }else{
                    cnt = 1;
                }
            }
        }
    }

}
