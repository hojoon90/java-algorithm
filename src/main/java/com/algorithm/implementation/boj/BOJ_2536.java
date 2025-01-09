package com.algorithm.implementation.boj;

import java.io.*;
import java.util.*;

public class BOJ_2536 {

    static int[][] board = new int[101][101];

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            String[] split = br.readLine().split(" ");
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);

            for(int j = y; j < y+10; j++){
                for(int k = x; k < x+10; k++){
                    board[j][k] += 1;
                }
            }
        }

        int allPaper = 0;

        for(int i = 1; i <= 100; i++){
            for(int j = 1; j <= 100; j++){
                if(board[i][j] > 0){
                    allPaper++;
                }
            }
        }

        System.out.println(allPaper);

    }

}
