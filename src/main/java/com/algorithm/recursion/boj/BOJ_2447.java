package com.algorithm.recursion.boj;

import java.io.*;
import java.util.*;

public class BOJ_2447 {

    static String[][] board = new String[2300][2300];

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            Arrays.fill(board[i], " ");
        }
        func(0, 0, count);

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void func(int x, int y, int count){
        if(count == 1) {
            board[x][y] = "*";
            return;
        }
        int dt = count / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1)
                    continue;
                func(x + dt*i , y + dt*j, dt);
            }
        }
    }

}
