package com.algorithm.bfs_dfs.boj;

import java.io.*;
import java.util.*;

public class BOJ_7562 {

    static int [][] board;
    static int [][] visited;
    static int [] dx = {2,0,-2,0};
    static int [] dy = {0,2,0,-2};
    static int [] dz = {1, -1};

    static Queue<Pair> q = new LinkedList<>();

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        for(int i = 0; i < count; i++){
            int n = Integer.parseInt(br.readLine());
            board = new int[n][n];
            visited = new int[n][n];

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    visited[j][k] = -1;
                }
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            int ix = Integer.parseInt(st.nextToken());
            int iy = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int goalX = Integer.parseInt(st.nextToken());
            int goalY = Integer.parseInt(st.nextToken());

            q.offer(new Pair(ix, iy));
            visited[ix][iy] = 0;
            while(!q.isEmpty()){
                Pair cur = q.poll();
                for(int j = 0; j < 4; j ++){
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];

                    for (int k = 0; k < 2; k++){
                        if(dx[j] == 0) {
                            nx = cur.x + dz[k];
                        }
                        if(dy[j] == 0) {
                            ny = cur.y + dz[k];
                        }
                        if(nx < 0 || nx >= n || ny < 0 || ny >= n){
                            continue;
                        }

                        if(visited[nx][ny] >= 0){
                            continue;
                        }

                        q.offer(new Pair(nx, ny));
                        visited[nx][ny] = visited[cur.x][cur.y] + 1;
                    }

                }
            }
            System.out.println(visited[goalX][goalY]);
        }

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
