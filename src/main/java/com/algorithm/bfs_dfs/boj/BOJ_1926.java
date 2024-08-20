package com.algorithm.bfs_dfs.boj;

import java.io.*;
import java.util.*;

public class BOJ_1926 {

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] board;
    static boolean[][] visited;
    static Queue<Pair> q;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        q = new LinkedList<>();

        int n = Integer.parseInt(st.nextToken()); // x
        int m = Integer.parseInt(st.nextToken()); // y

        board = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        int size = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visited[i][j] && board[i][j] == 1){
                    int tempSize = 0;
                    q.add(new Pair(i,j));
                    visited[i][j] = true;
                    while(!q.isEmpty()){
                        tempSize++;
                        Pair pair = q.poll();
                        for (int k = 0; k < 4; k++) {
                            int nextX = pair.x + dx[k];
                            int nextY = pair.y + dy[k];

                            if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
                                continue;
                            }

                            if(visited[nextX][nextY] || board[nextX][nextY] == 0){
                                continue;
                            }

                            Pair nextPair = new Pair(nextX, nextY);
                            visited[nextX][nextY] = true;
                            q.add(nextPair);
                        }
                    }
                    count++;
                    if(tempSize > size){
                        size = tempSize;
                    }
                }
            }

        }

        System.out.println(count);
        System.out.println(size);


    }

    public static void bfs(Pair pair, int n, int m){




    }

    static class Pair {
        int x;
        int y;

        public Pair (int x, int y){
            this.x = x;
            this.y = y;
        }
    }

}
