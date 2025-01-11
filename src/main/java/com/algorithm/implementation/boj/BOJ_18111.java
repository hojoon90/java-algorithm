package com.algorithm.implementation.boj;

import java.io.*;
import java.util.*;

public class BOJ_18111 {

    static int [][] board;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        board = new int[n][m];

        int min = 256;
        int max = 0;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(min > board[i][j]) min = board[i][j];
                if(max < board[i][j]) max = board[i][j];
            }
        }

        int time = Integer.MAX_VALUE;
        int height = 0;
        for(int i = min; i <= max; i++){

            int cnt = 0;
            int block = b;

            for(int j = 0; j < n; j++){
                for(int k = 0; k < m; k++){
                    if(i >= board[j][k]){
                        cnt += (i - board[j][k]);
                        block -= (i - board[j][k]);
                    }else{
                        cnt += ((board[j][k] - i)*2);
                        block += (board[j][k] -i);
                    }
                }
                if(block < 0) break;

                if(cnt <= time){
                    time = cnt;
                    height = i;
                }
            }

        }
        System.out.println(time+ " " + height);



    }

}
