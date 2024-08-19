package com.algorithm.bfs_dfs.baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_2583 {

    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static Queue<Pair> q = new LinkedList<>();

    public static void main(String[]args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int sy = Integer.parseInt(st.nextToken());
            int sx = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());

            for(int j = sx; j < ex; j++){
                for(int l = sy; l < ey; l++){
                    board[j][l] = -1;
                }
            }

        }

        List<Integer> list = new ArrayList<>();

        int count = 0; // 구분 카운트
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int size = 0;
                if(!visited[i][j] && board[i][j] == 0){
                    count++;
                    q.offer(new Pair(i, j));
                    visited[i][j] = true;
                }
                while(!q.isEmpty()){
                    Pair cur = q.poll();
                    for (int l = 0; l < 4; l++) {
                        int nx = cur.x + dx[l];
                        int ny = cur.y + dy[l];

                        if(nx < 0 || nx >= n || ny < 0 || ny >= m){
                            continue;
                        }

                        if(visited[nx][ny] || board[nx][ny] == -1){
                            continue;
                        }

                        visited[nx][ny] = true;
                        q.offer(new Pair(nx, ny));
                    }
                    size++;
                }
                if(size != 0){
                    list.add(size);
                }
            }
        }
        System.out.println(count);
        list.stream().sorted().forEach(i -> System.out.print(i +" "));

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
