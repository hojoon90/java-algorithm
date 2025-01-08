package com.algorithm.implementation.boj;

import java.io.*;
import java.util.*;

public class BOJ_17484 {

    static int n,m;
    static int[][] board;
    static int min = Integer.MAX_VALUE;
    static int[] direction = {-1, 0, 1};
    static int[] dp;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        board = new int[m][n];

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++){
            dp = new int[m];
            dp[0] = i;
            dfs(1, i, -1);
        }

        System.out.println(min);

    }

    static void dfs(int depth, int y, int dir){
        if(depth == m){
            int sum = board[0][dp[0]];
            for(int i = 1; i < m; i++){
                sum += board[i][dp[i]];
            }

            min = Math.min(min, sum);
            return;
        }

        for(int i = 0; i < 3; i++){
            int dy = y + direction[i];
            if(dy >= 0  && dy < n && dir != i){
                dp[depth] = dy;
                dfs(depth+1, dy, i);
            }
        }

    }

}
