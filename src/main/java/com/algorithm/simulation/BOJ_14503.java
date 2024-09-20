package com.algorithm.simulation;

import java.io.*;
import java.util.*;

public class BOJ_14503 {
    static int[][] board = new int[52][52];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Pair> q = new LinkedList<>();


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());   //0: 북, 1: 동, 2: 남, 3: 서

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int val = Integer.parseInt(st.nextToken());
                board[i][j] = val;
            }
        }
        //시작지점
        q.offer(new Pair(x, y));

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            //해당 구역이 청소 안됐으면 청소
            if (board[cur.x][cur.y] == 0) {
                board[cur.x][cur.y] = 2;
            }

            boolean isDirty = false;
            //4방향 체크 하면서 청소된 곳이 있는지 확인.
            for (int i = 0; i < 4; i++) {
                //반시계 회전
                d = (d + 3) % 4;

                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                //회전 후 앞의 값이 청소되지 않았으면 이동
                if (board[nx][ny] == 0) {
                    isDirty = true;
                    q.offer(new Pair(nx, ny));
                }
                if (isDirty) break;
            }

            //4방향 청소할 곳이 없을 때
            if (!isDirty) {
                int bx = cur.x - dx[d];
                int by = cur.y - dy[d];
                if (board[bx][by] == 1) break;
                else q.offer(new Pair(bx, by));
            }

        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 2) {
                    result += 1;
                }
            }
        }
        System.out.println(result);

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

