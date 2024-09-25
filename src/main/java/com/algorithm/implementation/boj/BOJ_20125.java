package com.algorithm.implementation.boj;

import java.io.*;
import java.util.*;

public class BOJ_20125 {

    static int[][] board = new int[1005][1005];

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Pair p = null;

        for(int i = 1; i <= n; i++){
            String[] a = br.readLine().split("");
            for (int j = 1; j <= n; j++) {
                int d = "_".equals(a[j-1]) ? 0 : 1;
                if(d == 1 && p == null) p = new Pair(i, j);   // 머리부분 체크
                board[i][j] = d;
            }
        }

        Pair heart = new Pair(p.x+1, p.y);
        System.out.println(heart.x+" "+heart.y);

        Pair waist = null;
        int left = 0;
        int right = 0;
        int height = 0;
        int lLeg = 0;
        int rLeg = 0;

        for (int i = heart.y - 1; i > 0; i--) {
            if(board[heart.x][i] == 1) left++;
            else break;
        }

        for (int i = heart.y + 1; i <= n; i++) {
            if(board[heart.x][i] == 1) right++;
            else break;
        }

        for (int i = heart.x + 1; i <= n; i++) {
            if(board[i][heart.y] == 1) height++;
            else {
                waist = new Pair(i-1, heart.y);
                break;
            }
        }

        //left
        for (int i = waist.x+1; i <= n; i++) {
            if(board[i][heart.y-1] == 1) lLeg++;
            else {
                break;
            }
        }


        //right
        for (int i = waist.x+1; i <= n; i++) {
            if(board[i][heart.y+1] == 1) rLeg++;
            else {
                break;
            }
        }

        System.out.println(left+" "+right+" "+height+" "+lLeg+" "+rLeg);

    }

    static class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

}
