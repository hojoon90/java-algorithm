package com.algorithm.simulation;

import java.io.*;
import java.util.*;

public class BOJ_3190 {

    static int[][] board = new int[101][101];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static LinkedList<Pair> dq = new LinkedList<>();

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x][y] = 2;
        }

        char[] cmdArr = new char[10005];
        int l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            cmdArr[x] = st.nextToken().charAt(0);
        }

        int d = 1;
        int time = 0;
        dq.offerFirst(new Pair(1, 1));
        while (true) {
            d %= 4;

            Pair cur = dq.peekFirst();
            board[cur.x][cur.y] = 1;
            time++;

            int nx = cur.x + dx[d];
            int ny = cur.y + dy[d];

            if(nx < 1 || nx > n || ny < 1 || ny > n){
                break;
            }
            if( board[nx][ny] == 1){
                break;
            }

            if(board[nx][ny] != 2){
                Pair p = dq.pollLast();   //꼬리부분 제거
                board[p.x][p.y] = 0;
            }

            char cmd = cmdArr[time];
            if(cmd == 'L'){
                d = d+1;
            }else if(cmd == 'D'){
                d = d+3;
            }
            dq.offerFirst(new Pair(nx, ny));
        }
        System.out.println(time);
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
