package com.algorithm.study.retryqueue.retry00;

import java.io.*;
import java.util.*;

/*
https://www.acmicpc.net/problem/15683
 */
public class BOJ_15683 {
    //실패코드
/*

    static int [][] board = new int[8][8];
    static Queue<Pair> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            String[] sArr = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                int data = Integer.parseInt(sArr[i]);
                if(data != 0 && data != 6){
                    q.offer(new Pair(i,j));
                }
                board[i][j] = data;
            }
        }



        while(!q.isEmpty()){
            Pair cameraLocate = q.poll();
            int camera = board[cameraLocate.x][cameraLocate.y];

            for(int tmp = 0; tmp < (tmp<<q.size()*2); tmp++){

                int brute = tmp;
                int dir = brute%4;
                brute /= 4;

                if(camera == 1){
                    findWatch(dir);
                }else if(camera == 2){
                    findWatch(dir);
                    findWatch(dir + 2);
                }else if(camera == 3){
                    findWatch(dir);
                    findWatch(dir + 1);
                }else if(camera == 4){
                    findWatch(dir);
                    findWatch(dir + 1);
                    findWatch(dir + 2);
                    findWatch(dir + 3);
                }
            }
        }

    }

    static void findWatch(int dir){

    }

    static class Pair{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
*/

    static int[][] board = new int[10][10];
    static int[][] board2 = new int[10][10];
    static List<Pair> cameraList = new ArrayList<>();
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int n, m;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int result = 0;
        for(int i = 0; i < n; i++){
            String[] sArr = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                int data = Integer.parseInt(sArr[j]);
                if(data != 0 && data != 6) cameraList.add(new Pair(i,j));
                if(data == 0) result++;

                board[i][j] = data;
            }
        }

        int allDir = 1;
        for (int i = 0; i < cameraList.size(); i++) {
            allDir *= 4;
        }

        for (int tmp = 0; tmp < allDir; tmp++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    board2[i][j] = board[i][j];
                }
            }
            int brute = tmp;
            for (int i = 0; i < cameraList.size(); i++) {
                int dir = brute % 4;
                brute /= 4;
                int nx = cameraList.get(i).x;
                int ny = cameraList.get(i).y;
                int camera = board[nx][ny];
                if(camera == 1){
                    findWatch(nx, ny, dir);
                }else if(camera == 2){
                    findWatch(nx, ny, dir);
                    findWatch(nx, ny, dir+2);
                }else if(camera == 3){
                    findWatch(nx, ny, dir);
                    findWatch(nx, ny, dir+1);
                }else if(camera == 4){
                    findWatch(nx, ny, dir);
                    findWatch(nx, ny, dir+1);
                    findWatch(nx, ny, dir+2);
                }else{
                    findWatch(nx, ny, dir);
                    findWatch(nx, ny, dir+1);
                    findWatch(nx, ny, dir+2);
                    findWatch(nx, ny, dir+3);
                }
            }
            int val = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(board2[i][j] == 0) val++;
                }
            }

            result = Math.min(result, val);
        }

        System.out.println(result);
    }

    static void findWatch(int x, int y, int dir){
        dir %= 4;
        while(true){
            x += dx[dir];
            y += dy[dir];

            if(x < 0 || x >= n || y < 0 || y >= m){
                return;
            }

            if(board2[x][y] == 6){
                return;
            }

            if(board2[x][y] != 0) continue;
            board2[x][y] = 7;
        }
    }

    static class Pair{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
