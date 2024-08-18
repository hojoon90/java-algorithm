package com.algorithm.bfs_dfs.baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_7569 {

    static int [][][] days = new int [101][102][102];
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[] dz = {0,1,-1};
    static Queue<Pair> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // x
        int m = Integer.parseInt(st.nextToken()); // y
        int h = Integer.parseInt(st.nextToken()); // z

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    int tomato = Integer.parseInt(st.nextToken());
                    if(tomato == 1){
                        q.add(new Pair(k,j,i));
                    }
                    if(tomato == 0){
                        days[i][j][k] = -1;
                    }

                }
            }
        }
        while(!q.isEmpty()){
            Pair cur = q.poll();
            for (int i = 0; i < 3; i++) {
                int nz = cur.z + dz[i];

                if(nz < 0 || nz >= h){
                    continue;
                }

                if(days[nz][cur.y][cur.x] >= 0){
                    continue;
                }

                days[nz][cur.y][cur.x] = days[cur.z][cur.y][cur.x] + 1;
                q.offer(new Pair(cur.x, cur.y, nz));
            }

            for (int j = 0; j < 4; j++) {
                int nx = cur.x + dx[j];
                int ny = cur.y + dy[j];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m){
                    continue;
                }

                if(days[cur.z][ny][nx] >= 0){
                    continue;
                }

                days[cur.z][ny][nx] = days[cur.z][cur.y][cur.x] + 1;
                q.offer(new Pair(nx, ny, cur.z));
            }


        }

        int result = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    if(days[i][j][k] == -1){
                        System.out.println(-1);
                        return;
                    }
                    result = Math.max(days[i][j][k], result);

                }
            }
        }

        System.out.println(result);

    }

    static class Pair{
        int x;
        int y;
        int z;

        public Pair(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

}
