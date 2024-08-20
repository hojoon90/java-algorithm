package com.algorithm.bfs_dfs.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 완전 탐색 문제.
 *
 * 문제 자체는 파악을 했지만, 치즈 내부 체크를 어떻게 할지 몰라서 풀이를 먼저 확인한 문제.
 * 이 문제에서는 먼저 외부공기쪽을 체크해주고, 그리고 나서 치즈를 녹이는 방식으로 접근해주면 된다.
 * 먼저 너비탐색 혹은 깊이탐색을 통해 치즈의 바깥쪽을 모두 체크해주면 되는데, 가장자리는 무조건 공기만 있으므로 0,0부터 탐색을 해주며 외부쪽을 체크한다.
 * 체크 중 치즈가 있을 경우 너비탐색의 경우 큐에 담지 않으면 되고, 깊이탐색의 경우 스택에 쌓지 않으면 된다(재귀를 태우지 않으면 된다.)
 * 그리고 전체 노드를 담을 때 치즈의 위치를 별도의 리스트에 담아주면서 치즈 개수도 함께 카운팅해준다.
 * 외부공기 체크가 끝나면 치즈가 녹는 시간을 재면 되는데, 아까 저장해둔 치즈 위치 리스트를 반복문으로 돌리면서 치즈의 상하좌우를 체크한다.
 * 이때 외부공기(2라고 체크)가 2개 이상 있을 경우, 해당 위치 치즈를 0으로 바꿔주고, 치즈를 지워준다.
 * 이렇게 계속 반복을 하면서 최종 시간을 체크해주면 된다.
 *
 * 확실히 문제가 응용돼서 들어오면 풀이가 바로 막혀버리는 것 같다.
 * 치즈 문제처럼 체크된 곳 외부 부분을 확인해야하는 문제가 나오면 지금과 같은 방식으로 체크 후 처리해주면 될 것 같다.
 *
 */
//https://www.acmicpc.net/problem/2638
public class BOJ_2638 {

    public static int x;
    public static int y;
    public static int[] xDir = {-1, 1, 0, 0};
    public static int[] yDir = {0, 0, 1, -1};
    public static int[][] nodeList;
    public static Queue<Position> q = new LinkedList<>();
    public static boolean[][] visited;
    public static ArrayList<Position> cheeseList = new ArrayList<>();
    public static int cheeseCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int time = 0;


        String[] s = br.readLine().split(" ");
        y = Integer.parseInt(s[0]);
        x = Integer.parseInt(s[1]);

        nodeList = new int[y][x];
        for (int i = 0; i < y; i++) {
            String[] nodes = br.readLine().split(" ");
            for (int j = 0; j < nodes.length; j++) {
                nodeList[i][j] = Integer.parseInt(nodes[j]);
                if(nodeList[i][j] == 1){
                    cheeseList.add(new Position(j, i));
                    cheeseCnt++;
                }
            }
        }

        while (cheeseCnt != 0){
            time++;
            visited = new boolean[y][x];
            bfs();
            melting();
        }
        System.out.println(time);
    }

    //외부 공기 찾기
    public static void bfs(){
        q.offer(new Position(0, 0));
        visited[0][0] = true;
        nodeList[0][0] = 2;

        while (!q.isEmpty()){
            Position p = q.poll();

            for (int i = 0; i < 4; i++) {
                int newX = p.x + xDir[i];
                int newY = p.y + yDir[i];

                if (newX >= 0 && newX < x && newY >=0 && newY < y
                    && !visited[newY][newX] && nodeList[newY][newX] != 1
                ){
                    nodeList[newY][newX] = 2;
                    q.offer(new Position(newX, newY));
                    visited[newY][newX] = true;
                }
            }

        }
    }

    public static void melting(){
        for (int i = 0; i < cheeseList.size(); i++) {
            Position p = cheeseList.get(i);
            int count = 0;
            for (int j = 0; j < 4; j++) {
                int newX = p.x + xDir[j];
                int newY = p.y + yDir[j];

                if(nodeList[newY][newX] == 2){
                    count++;
                }

            }
            if(count >= 2){
                nodeList[p.y][p.x] = 0;
                cheeseList.remove(p);
                cheeseCnt--;
                i--;    //리스트에서 객체를 제거하므로 리스트의 다시 맨 첫번째를 가져오기 위해 - 해준다.(for문을 돌면서 계속 0을 가져옴)
            }

        }
    }

    public static class Position{
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
