package com.algorithm.bfs_dfs.baekjoon;

import java.io.*;
import java.util.*;

/**
 * BFS 응용문제. DFS로도 풀수 있는 것 같지만 BFS가 더 약하다고 생각 돼 BFS로 풀이
 * 이번에는 필드와 이동에 필요한 변수까지는 잘 만들었는데 마지막 마무리 로직을 제대로 하지 못했다.
 * 그리고 방문체크는 무조건! 해주자. 방문체크에 대한 로직을 빼놓고 풀고있었다.
 * BFS를 사용해서 풀되, 전 좌표를 다 스캔해야한다.
 * 0,0 부터 X,Y 까지 반복문을 돌면서 방문을 하지 않았는데 배추가 있는 좌표면 큐 안에 넣어준다.
 * 그리고 나서 큐 안에서 좌표이동을 하면서 (이때 상하좌우 총 4개의 좌표를 얻는다) 배추가 있는지 확인하고, 있으면 큐에 넣어준다.
 * 이렇게 되면 현재 좌표 기준으로 최대 4개의 좌표가 큐에 쌓이게 된다. 방문체크는 필수다.
 * 그렇게 돌면서 주변에 인접한 배추를 모두 찾으면(큐 내용을 모두 수행하면) 벌레하나를 놓을 수 있으므로 bugCnt 를 하나 올려준다.
 * 이렇게 전좌표를 스캔하면 필요한 최소의 벌레수를 얻을 수 있다.
 */
//https://www.acmicpc.net/problem/1012
public class BOJ_1012 {

    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,1,-1};
    public static boolean[][] visited;
    public static int [][] cabbageField;
    public static Queue<Position> q = new LinkedList<>();
    public static int x;
    public static int y;


    // 배추 위치 세팅
    // 방향 설정
    // 배추 좌표로 가서 탐색
    // 적당한 위치에 배추가 있으면 체크?
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCnt; i++) {
            int bugCnt = 0;
            String[] testCase = br.readLine().split(" ");
            x = Integer.parseInt(testCase[0]);
            y = Integer.parseInt(testCase[1]);
            int cabbageCnt = Integer.parseInt(testCase[2]);

            cabbageField = new int[y][x];
            visited = new boolean[y][x];
            for (int j = 0; j < cabbageCnt; j++) {
                String[] cabbageP = br.readLine().split(" ");
                int cx = Integer.parseInt(cabbageP[0]);
                int cy = Integer.parseInt(cabbageP[1]);
                cabbageField[cy][cx] = 1;
            }

            for (int j = 0; j < y; j++) {
                for (int k = 0; k < x; k++) {
                    if (!visited[j][k] && cabbageField[j][k] == 1) {
                        bfs(j, k);
                        bugCnt++;
                    }
                }
            }
            System.out.println(bugCnt);
        }

    }

    private static void bfs(int j, int k) {
        q.offer(new Position(k, j));
        visited[j][k] = true;
        while (!q.isEmpty()) {
            Position poll = q.poll();
            for (int l = 0; l < 4; l++) {
                int newPx = poll.px + dx[l];
                int newPy = poll.py + dy[l];
                int cabbage = cabbageField[newPy][newPx];
                if (isInField(newPx, newPy) && cabbage == 1 && !visited[newPy][newPx]) {
                    q.offer(new Position(newPx, newPy));
                    visited[newPy][newPx] = true;
                }
            }
        }
    }

    private static boolean isInField(int newPx, int newPy) {
        return newPx >= 0 && newPx < x && newPy >= 0 && newPy < y;
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
