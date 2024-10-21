package com.algorithm.study.retryqueue.retry02;

import java.io.*;
import java.util.*;

/*
https://www.acmicpc.net/problem/11559
 */
public class Retry_2 {

//    static char[][] board = new char[12][6];
//    static boolean[][] checked = new boolean[12][6];
//    static Queue<Pair> q = new LinkedList<>();
//    static int[] dx = {1,0,-1,0};
//    static int[] dy = {0,1,0,-1};
//
//    public static void main(String[] args) throws IOException{
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        for(int i = 0; i < 12; i++){
//            char[] line = br.readLine().toCharArray();
//            for(int j = 0; j < 6; j++){
//                board[i][j] = line[j];
//            }
//        }
//
//        int cnt = 0;
//
//        while(true){
//            boolean isPop = false;
//            int sameCnt = 1;
//            List<Pair> plist = new ArrayList<>();
//            for(int i = 0; i < 6; i++){
//                if(board[11][i] != '.'){
//                    q.offer(new Pair(11, i));
//                    plist.add(new Pair(11, i));
//                    break;
//                }
//            }
//
//            while(!q.isEmpty()){
//                Pair p = q.poll();
//                checked[p.x][p.y] = true;
//                char puyoColor = board[p.x][p.y];
//
//                for(int i = 0; i < 4; i++){
//                    int nx = p.x + dx[i];
//                    int ny = p.y + dy[i];
//
//                    if(nx < 0 || nx >= 12 || ny < 0 || ny >= 6){
//                        continue;
//                    }
//
//                    if(checked[nx][ny]){
//                        continue;
//                    }
//
//                    if(board[nx][ny] == puyoColor){
//                        sameCnt++;
//                        q.offer(new Pair(nx, ny));
//                        plist.add(new Pair(nx, ny));
//                        checked[nx][ny] = true;
//                    }
//                }
//            }
//
//            //뿌요
//            if(sameCnt >= 4){
//                cnt++;
//                for (Pair p : plist){
//                    board[p.x][p.y] = '.';
//                }
//                isPop = true;
//            }
//
//            if(!isPop){
//                break;
//            }
//
//            //터졌으면 내려온다
//            if(isPop){
//                for(int i = 1; i < 12; i++){
//                    for (int j = 0; j < 6; j++) {
//                        for (int k = i; k >=0 ; k--) {
//                            if(board[k][j] == '.'){
//                                char tmp = board[k][j];
//                                board[k][j] = board[k-1][j];
//                                board[k-1][j] = tmp;
//                            }
//                        }
//                    }
//
//                }
//            }
//        }
//        System.out.println(cnt);
//
//    }
//
//    static class Pair{
//        int x;
//        int y;
//
//        public Pair(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }

}
