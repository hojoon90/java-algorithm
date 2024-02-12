package com.algorithm.bfs_dfs.softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SfT_6282 {

    public static ArrayList<ArrayList<Integer>> nodeList = new ArrayList<>();
    public static boolean[][] visited;
    public static int[] xDir = {-1, 1, 0, 0};
    public static int[] yDir = {0, 0, 1, -1};
    public static int count;
    public static ArrayList<Integer> barrierList = new ArrayList<>();
    public static Queue<Position> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        count = Integer.parseInt(br.readLine());

        visited = new boolean[count][count];
        for (int i = 0; i < count; i++) {
            nodeList.add(new ArrayList<>());
            String[] sArr = br.readLine().split("");
            for (int j = 0; j < count; j++) {
                for (String s : sArr) {
                    nodeList.get(i).add(Integer.parseInt(s));
                }
            }
        }
        int totalCnt =0;

        for (int y = 0; y < count; y++) {
            for (int x = 0; x < count; x++) {
                if(nodeList.get(y).get(x) == 1 && !visited[y][x]){
                    totalCnt++;
                    bfs(x, y);
                }
            }
        }

        System.out.println(totalCnt);
        barrierList.stream().sorted().forEach(i -> System.out.println(i));
    }

    public static void bfs(int x, int y) {
        q.offer(new Position(x, y));
        visited[y][x] = true;
        int barrier = 1;
        while (!q.isEmpty()) {
            Position poll = q.poll();
            for (int i = 0; i <4; i++) {
                int newX = poll.x + xDir[i];
                int newY = poll.y + yDir[i];
                if (newX < count && newX >= 0 && newY < count && newY >= 0
                        && nodeList.get(newY).get(newX) == 1 && !visited[newY][newX]
                ) {
                    q.offer(new Position(newX, newY));
                    visited[newY][newX] = true;
                    barrier++;
                }
            }
        }
        if (barrier != 0) barrierList.add(barrier);
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
