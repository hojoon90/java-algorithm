package com.algorithm.implementation.boj;

import java.io.*;
import java.util.*;

public class BOJ_2167 {

    static int [][] board;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");
        int x = Integer.parseInt(arr[0]);
        int y = Integer.parseInt(arr[1]);

        board = new int[x][y];

        for(int i = 0; i < x; i++){
            String[] arr2 = br.readLine().split(" ");
            for(int j = 0; j < y; j++){
                board[i][j] = Integer.parseInt(arr2[j]);
            }
        }

        int k = Integer.parseInt(br.readLine());
        for(int i = 0; i < k; i++){
            int sum = 0;

            String[] point = br.readLine().split(" ");
            int ii = Integer.parseInt(point[0]);
            int jj = Integer.parseInt(point[1]);
            int xx = Integer.parseInt(point[2]);
            int yy = Integer.parseInt(point[3]);

            for(int l = ii-1; l < xx; l++){
                for(int m = jj - 1; m < yy; m++){
                    sum += board[l][m];
                }
            }

            System.out.println(sum);
        }


    }

}
