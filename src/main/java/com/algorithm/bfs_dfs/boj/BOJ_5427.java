package com.algorithm.bfs_dfs.boj;

import java.io.*;
import java.util.*;


public class BOJ_5427 {

    static char[][] board;
    static int[][] fVisited;
    static int[][] hVisited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        for(int i = 0; i < cnt; i++){
            //큐는 테스트 데이터 초기화 시 같이 초기화 되어야 함.
            Queue<Pair> fq = new LinkedList<>();
            Queue<Pair> hq = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken()); // y
            int n = Integer.parseInt(st.nextToken()); // x
            boolean escape = false;

            board = new char[n][m];
            fVisited = new int[n][m];
            hVisited = new int[n][m];

            for (int j = 0; j < n; j++) {
                char[] strArr = br.readLine().toCharArray();
                for (int k = 0; k < m; k++) {
                    if(strArr[k] == '@'){
                        hq.offer(new Pair(j, k));
                        hVisited[j][k] = 1;
                    }else if(strArr[k] == '*'){
                        fq.offer(new Pair(j, k));
                        fVisited[j][k] = 1;
                    }
                    board[j][k] = strArr[k];
                }
            }

            while(!fq.isEmpty()){
                Pair cur = fq.poll();
                for(int j = 0; j < 4; j++){
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];

                    if(nx < 0 || nx >= n || ny < 0 || ny >= m ){
                        continue;
                    }

                    //조건의 순서가 중요
                    if(board[nx][ny] == '#' || fVisited[nx][ny] > 0){
                        continue;
                    }

                    fVisited[nx][ny] = fVisited[cur.x][cur.y] + 1;
                    fq.offer(new Pair(nx, ny));
                }
            }

            while(!hq.isEmpty() && !escape){
                Pair cur = hq.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];

                    if(nx < 0 || nx >= n || ny < 0 || ny >= m){
                        System.out.println(hVisited[cur.x][cur.y]);
                        escape = true;
                        break;
                    }

                    //조건의 순서가 중요
                    if(board[nx][ny] == '#' || hVisited[nx][ny] > 0){
                        continue;
                    }

                    if (fVisited[nx][ny] != 0 && fVisited[nx][ny] <= hVisited[cur.x][cur.y] + 1) {
                        continue;
                    }

                    hVisited[nx][ny] = hVisited[cur.x][cur.y] + 1;
                    hq.offer(new Pair(nx, ny));
                }
            }
            if(!escape){
                System.out.println("IMPOSSIBLE");
            }

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
