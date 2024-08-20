package com.algorithm.bfs_dfs.boj;

import java.io.*;
import java.util.*;

public class BOJ_4179 {

    static String[][] board;
    static int[][] fire;
    static int[][] jh;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static Queue<Pair> fireQ = new LinkedList<>();
    static Queue<Pair> jhQ = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        board = new String[n][m];
        fire = new int[n][m];
        jh = new int[n][m];

        for(int i = 0; i < n; i++){
            String[] split = br.readLine().split("");
            for(int j = 0; j < m; j++){
                board[i][j] = split[j];
                jh[i][j] = -1;
                fire[i][j] = -1;
                if("J".equals(split[j])){
                    jhQ.add(new Pair(i, j));
                    jh[i][j] = 0;
                } else if ("F".equals(split[j])) {
                    fireQ.add(new Pair(i, j));
                    fire[i][j] = 0;
                }

            }
        }

        while(!fireQ.isEmpty()){
            Pair poll = fireQ.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = poll.x + dx[i];
                int nextY = poll.y + dy[i];

                if( nextX >= n || nextY >= m || nextX < 0 || nextY < 0) {
                    continue;
                }
                if(fire[nextX][nextY] >= 0 || "#".equals(board[nextX][nextY])){
                    continue;
                }

                fire[nextX][nextY] = fire[poll.x][poll.y] + 1;
                fireQ.offer(new Pair(nextX, nextY));
            }
        }

        while(!jhQ.isEmpty()){
            Pair poll = jhQ.poll();
            for(int i = 0; i < 4; i++){
                int nextX = poll.x + dx[i];
                int nextY = poll.y + dy[i];

                if(nextX >= n || nextY >= m || nextX < 0 || nextY < 0){
                    System.out.println(jh[poll.x][poll.y] + 1);
                    return;
                }

                if(jh[nextX][nextY] >= 0 || "#".equals(board[nextX][nextY])){
                    continue;
                }

                //fire 값이 -1(벽)이 아니고, 지훈이 탈출시간이 불 번진 시간보다 크면 패스(탈출 못함)
                if(fire[nextX][nextY] != -1 && fire[nextX][nextY] <= jh[poll.x][poll.y] + 1){
                    continue;
                }

                jh[nextX][nextY] = jh[poll.x][poll.y] + 1;
                jhQ.offer(new Pair(nextX, nextY));
            }
        }

        System.out.println("IMPOSSIBLE");

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
