package com.algorithm.bfs_dfs.boj;

import java.io.*;
import java.util.*;

public class BOJ_10026 {

    static String[][] board;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static Queue<Pair> q = new LinkedList<>();
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        board = new String[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String[] strArr = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                board[i][j] = strArr[j];
            }
        }

        int groupA = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    groupA++;
                    bfs(i, j);
                }
            }
        }

        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j].equals("G")){
                    board[i][j] = "R";
                }
            }
        }

        int groupB = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    groupB++;
                    bfs(i, j);
                }
            }
        }

        System.out.print(groupA+" "+groupB);
    }

    private static void bfs(int x, int y) {
        q.offer(new Pair(x,y));
        visited[x][y] = true;
        while(!q.isEmpty()){
            Pair current = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = current.x + dx[k];
                int ny = current.y + dy[k];

                if(nx < 0 || nx >= n || ny < 0 || ny >= n){
                    continue;
                }

                if(visited[nx][ny] || !board[x][y].equals(board[nx][ny])){
                    continue;
                }

                visited[nx][ny] = true;
                q.add(new Pair(nx, ny));
            }
        }
    }

    static class Pair{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}
