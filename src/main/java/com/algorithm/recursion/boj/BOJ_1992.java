package com.algorithm.recursion.boj;

import java.io.*;
import java.util.*;

public class BOJ_1992 {

    static int[][] board = new int[64][64];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        for(int i = 0; i < count; i++){
            String[] arr = br.readLine().split("");
            for(int j = 0; j < count; j++){
                board[i][j] = Integer.parseInt(arr[j]);
            }
        }

        func(0, 0, count);

        System.out.println(sb);
    }

    static void func(int x, int y, int count){
        if(check(x, y, count)){
            sb.append(board[x][y]);
            return;
        }else{
            sb.append("(");
            int half = count/2;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    func(x + i*half, y + j*half, half);
                }
            }
        }
        sb.append(")");
    }

    static boolean check(int x, int y, int n){
        for (int i = x; i < x+n; i++) {
            for (int j = y; j < y+n; j++) {
                if(board[i][j] != board[x][y]){
                    return false;
                }
            }
        }
        return true;
    }

}
