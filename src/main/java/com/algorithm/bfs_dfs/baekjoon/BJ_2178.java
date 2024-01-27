package com.algorithm.bfs_dfs.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS 미로 문제
 * DFS보다 BFS가 좀 더 생소해서 풀어본 문제였는데 생각보다 난이도가 있었다.
 * 우선 이동 개념에 대해 기억해두어야 할 거 같다. 미로 세팅은 잘 했는데 이동로직에 대한 구현을 하나도 못했다.
 * 여기서는 미로 자체에 대한 2차원 배열(miro)과 해당 미로의 거리를 계산할 수 있는 2차원 배열(distance)을 별도로 두었다
 * 그리고 상하좌우 좌표를 계산할 수 있는 가로축 세로축 배열을 각각 만들어주었다.
 * 미로를 만든 후 거리를 모두 -1로 초기화 해준다.
 * 이 값을 통해 상하좌우 계산 시 이미 지나간 길이면 안지나가도록 처리해준다.
 * 그 후 시작 지점을 distance 값 0으로 초기화하고 큐안에 시작 좌표를 넣어준다.
 * while문 안에서 for문으로 상하좌우를 계산하고 이동 가능한 좌표는 이전 좌표 거리값에 +1을 해준다.
 *     - 만약 (0,0)에서 (1,0)으로 이동했으면 (1,0)의 값은 0(이전좌표 거리값)+1 = 1이 된다.
 * 신규 좌표를 미로와 거리에 각각 대입하여 벽 혹은 이미 지나간 길이면 패스하고 다음 값을 처리한다.
 * 이동할 수 있는 길이라 판단되면 새로운 좌표를 큐에 넣어주고 거리값을 1 올려준다.
 * while문을 탈출하면 distance 2차원배열의 마지막 값+1을 출력해준다. (+1은 스타트 값이 0이기 때문)
 */
//https://www.acmicpc.net/problem/2178
public class BJ_2178 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strArr = br.readLine().split(" ");
        int x = Integer.parseInt(strArr[1]);
        int y = Integer.parseInt(strArr[0]);

        char[][] miro = new char[y][x];
        int[] dx = {-1,1,0,0};  //좌우상하
        int[] dy = {0,0,1,-1};
        int[][] distance = new int[y][x];
        Queue<Position> q = new LinkedList<>();

        for (int yCnt = 0; yCnt < y; yCnt++) {
            String road = br.readLine();
            for (int xCnt = 0; xCnt < x; xCnt++) {
                miro[yCnt][xCnt] = road.charAt(xCnt);
                distance[yCnt][xCnt] = -1;    //모든길 -1 초기화
            }
        }

        //시작점 초기화
        q.offer(new Position(0, 0));
        distance[0][0] = 0;

        //길찾기
        while (!q.isEmpty()){
            Position p = q.poll();

            //방향 찾기. 순서대로 좌우상하
            for (int i = 0; i < 4; i++) {
                int newDx = p.x + dx[i];
                int newDy = p.y + dy[i];

                // -1 혹은 미로 밖으로 나가면 패스
                if (newDx < 0 || newDx >= x || newDy < 0 || newDy >= y) {
                    continue;
                }
                //미로가 0(벽)이거나 distance가 -1이 아닐때(이미 방문 했을때)
                if(miro[newDy][newDx] == '0' || distance[newDy][newDx] != -1){
                    continue;
                }

                q.offer(new Position(newDx, newDy));
                distance[newDy][newDx] = distance[p.y][p.x] + 1;
            }
        }
        System.out.println(distance[y-1][x-1] + 1);
    }

    public static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
