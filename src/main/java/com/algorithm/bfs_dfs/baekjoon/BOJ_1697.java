package com.algorithm.bfs_dfs.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 너비탐색을 통한 최소 숫자 찾기
 *
 * 시작점을 기준으로 이동할 수 있는 모든 위치를 체크해가면서 결과위치와 동일한 위치로 갔을 때 이동 횟수를 출력해주면 된다.
 * 큐를 사용하는거까진 좋았는데, 너무 문제를 단순하게 처리하려고 생각해서 못푼 문제..
 * 일단 시작 좌표를 기준으로 도착 좌표까지 이동하는 횟수를 저장하는 배열(checked)이 필요하다.
 * 그 후 +1, -1, *2 의 모든 케이스에 대해 이동 좌표를 구한 후 해당 위치에 현재 이동 값+1을 해준다.
 * 이렇게 너비탐색으로 계속 찾아가면서 목표좌표에 도달하면 값을 출력해주면 된다.
 *
 * 너비탐색은 이런 유형도 있다는 것을 알게 된 문제였다.
 *
 */
public class BOJ_1697 {

    public static Queue<Integer> q = new LinkedList<>();
    public static int N;
    public static int K;
    public static int[] checked = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] position = br.readLine().split(" ");
        N = Integer.parseInt(position[0]);
        K = Integer.parseInt(position[1]);

        if (N == K){
            System.out.println(0);
        }else{
            bfs();
        }
    }

    public static void bfs() {
        //시작 좌표를 넣는다.
        q.offer(N);
        //시작 좌표의 체크값 1
        checked[N] = 1;

        while (!q.isEmpty()){
            //저장된 좌표를 꺼낸다.
            Integer pn = q.poll();
            for (int i = 0; i < 3; i++) {
                int next;

                //+1, -1, *2 를 했을 때 좌표를 구한다.
                if (i == 0) {
                    next = pn + 1;
                } else if (i == 1) {
                    next = pn - 1;
                } else {
                    next = pn * 2;
                }

                //계산한 좌표값중 목표 좌표값이 있으면 해당 좌표의 checked값을 출력.
                if (next == K) {
                    System.out.println(checked[pn]);
                    return;
                }

                //checked에 한번도 들어가지 않았으면 큐에 좌표를 넣고 checked에 현재 이동 거리값 +1을 해준다.
                if (next >= 0 && next < checked.length && checked[next] == 0) {
                    q.add(next);
                    checked[next] = checked[pn] + 1;
                }
            }

        }
    }
}
