package com.algorithm.bfs_dfs.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 오랜만에 풀었던 BFS 문제. 마지막으로 푼지 2주일이 다 돼가서 그런지 거의다 까먹어 버렸다...
 * 값 세팅까지는 어찌어찌 했지만 구현을 전혀 하지 못해서 못 풀었다.
 * 이전 문제들과 다른점이라면 0,0에서부터 탐색하면서 내려가는 문제였지만, 이번 문제는 1이 있는 곳에서 부터 탐색이 진행되어야 한다.
 * 전에 풀었던 미로문제와도 유사하면서도 다른 문제였다.
 *
 * 이 문제에서 핵심은 익은 토마토가 있는 위치를 큐에 저장하고 시작하는 것이다.
 * 그렇게 해야 너비탐색이 시작되면서 익은 토마토의 위치에서 부터 익은 토마토를 통해 날짜 계산을 할 수 있기 때문이다.
 * visited boolean 배열로 방문체크를 해도 되나 했지만, 문제에서 요구하는 것은 토마토가 다 익은 날짜를 구하는 것이다.
 * 그렇기 때문에 익은 토마토가 있는 위치에서 부터 점점 탐색해가면서 숫자를 1씩 올려준다. 이 숫자가 곧 익은 날짜가 되는 것이다.
 * 너비 탐색으로 각 위치별 토마토가 익은 날짜들을 세팅해주고, 마지막에 다시 모든 위치를 돌면서 가장 큰 수 (=다 익은 날짜 수)를 구해주면 된다.
 *
 */
public class BOJ_7576 {

    public static int[][] box, dist;
    public static Queue<Position> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] xy = br.readLine().split(" ");
        int x = Integer.parseInt(xy[0]);
        int y = Integer.parseInt(xy[1]);

        int[] xDir = {-1, 1, 0, 0};
        int[] yDir = {0, 0, 1, -1};

        box = new int[y][x];
        dist = new int[y][x];
        for (int i = 0; i < y; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < s.length; j++) {
                box[i][j] = Integer.parseInt(s[j]);
                if (box[i][j] == 1) q.offer(new Position(j, i));
                if (box[i][j] == 0) dist[i][j] = -1;
            }
        }

        while (!q.isEmpty()) {
            Position position = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = position.px + xDir[i];
                int ny = position.py + yDir[i];
                if (nx < 0 || nx >= x || ny < 0 || ny >= y) continue;
                if (dist[ny][nx] >= 0) continue;
                dist[ny][nx] = dist[position.py][position.px] + 1;
                q.offer(new Position(nx, ny));
            }
        }

        int result = 0;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                // 토마토가 안 익은게 있으면
                if (dist[i][j] == -1) {
                    System.out.println(-1);
                    return;
                }
                result = Math.max(result, dist[i][j]);
            }
        }
        System.out.println(result);

    }

    public static class Position {
        int px;
        int py;

        public Position(int px, int py) {
            this.px = px;
            this.py = py;
        }
    }

}
