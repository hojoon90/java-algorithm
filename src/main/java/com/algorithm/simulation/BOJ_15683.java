package com.algorithm.simulation;

import java.io.*;
import java.util.*;

public class BOJ_15683 {

    static int[][] board = new int [10][10];
    static int[][] board2 = new int [10][10];
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static List<Pair> cctv = new ArrayList<>();
    static int n;
    static int m;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int result = 0;

        for (int i = 0; i < n; i++) {
            String[] data = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                int d = Integer.parseInt(data[j]);
                if(d != 0 && d != 6) cctv.add(new Pair(i, j));
                if(d == 0) result++;
                board[i][j] = d;
            }
        }

        int allDir = 1;
        for(int i = 0; i < cctv.size(); i++){
            allDir += 4;
        }

        for (int tmp = 0; tmp < allDir; tmp++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    board2[i][j] = board[i][j];
                }
            }
            int brute = tmp;
            for (int i = 0; i < cctv.size(); i++) {
                int dir = brute % 4;
                brute /= 4;
                int x = cctv.get(i).x;
                int y = cctv.get(i).y;
                if(board[x][y] == 1){
                    upd(x,y,dir);
                }else if(board[x][y] == 2){
                    upd(x,y,dir);
                    upd(x,y,dir+2);
                }else if(board[x][y] == 3){
                    upd(x,y,dir);
                    upd(x,y,dir+1);
                }else if(board[x][y] == 4){
                    upd(x,y,dir);
                    upd(x,y,dir+1);
                    upd(x,y,dir+2);
                }else{
                    upd(x,y,dir);
                    upd(x,y,dir+1);
                    upd(x,y,dir+2);
                    upd(x,y,dir+3);
                }
            }
            int val = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(board2[i][j] == 0) val++;
                }
            }
            result = Math.min(result, val);
        }
        System.out.println(result);
    }

    static void upd(int x, int y, int dir){
        dir %= 4;
        while(true){
            x += dx[dir];
            y += dy[dir];
            if(OOB(x,y) || board2[x][y] == 6){
                return;
            }
            if(board2[x][y] != 0) continue;
            board2[x][y] = 7;
        }
    }

    static boolean OOB(int a, int b){ // Out Of Bounds 확인
        return a < 0 || a >= n || b < 0 || b >= m;
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
