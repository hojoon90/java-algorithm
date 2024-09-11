package com.algorithm.study.retryqueue.retry00;

import java.io.*;
import java.util.*;

/*
https://www.acmicpc.net/problem/11559
 */
public class BOJ_11559 {

    //실패
/*
    static char[][] board = new char[12][6];
    static Queue<Pair> q = new LinkedList<>();
    static int[] x = {1,0,-1,0};
    static int[] y = {0,1,0,-1};

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 12; i++) {
            board[i] = br.readLine().toCharArray();
        }

        //4개가 되면 없앤다.(연쇄 수가 올라간다.)
        //없앤 자리 위쪽에 뿌요가 있으면 내린다.
        while (!q.isEmpty()) {
            for (int i = 0; i < 6; i++) {
                if(board[12][i] != '.'){
                    q.offer(new Pair(12,i));
                }
            }

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
*/

    static char[][] board = new char[12][6];
    static boolean[][] visited = new boolean[12][6];
    static int[] x = {1,0,-1,0};
    static int[] y = {0,1,0,-1};
    static boolean isPop = true;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 12; i++) {
            board[i] = br.readLine().toCharArray();
        }
        int result = 0;

        //뿌요가 터졌을때 처리로직.
        while(isPop){
            isPop = false;
            //터졌으면 위에걸 아래로 내려준다.
            for (int i = 0; i < 6; i++) {
                for (int j = 10; j >= 0; j--) {
                    int tmp = j;
                    while(tmp < 11 && board[tmp+1][i] == '.'){
                        char t = board[tmp][i];
                        board[tmp][i] = board[tmp+1][i];
                        board[tmp+1][i] = t;
                        tmp++;
                    }
                }
            }

            //뿌요를 찾아서 처리한다.
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    //bfs
                    if(!visited[i][j] && board[i][j] != '.'){
                        bfs(i, j);
                    }
                }
            }
            //bfs 처리후 터졌으면 result++
            if(isPop)result++;

            //새로 처리를 위해 visited 초기
            for (int k = 0; k < 12; k++) {
                for (int l = 0; l < 6; l++) {
                    visited[k][l] = false;
                }
            }
        }
        System.out.println(result);
    }

    static void bfs(int i, int j) {
        Queue<Pair> q = new LinkedList<>();
        List<Pair> p = new ArrayList<>();

        visited[i][j] = true;
        char val = board[i][j];
        q.offer(new Pair(i, j));
        p.add(new Pair(i, j));

        while(!q.isEmpty()){
            Pair cur = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = cur.x + x[k];
                int ny = cur.y + y[k];

                if( nx < 0 || nx >= 12 || ny < 0 || ny >= 6){
                    continue;
                }
                if(visited[nx][ny] || board[nx][ny] != val || board[nx][ny] == '.'){
                    continue;
                }
                visited[nx][ny] = true;
                q.offer(new Pair(nx, ny));
                p.add(new Pair(nx, ny));
            }
        }

        //뿌요 '4개보다 크거나 같으면' 모였으므로 터짐 처리
        if(p.size() >= 4){
            isPop = true;
            for(Pair pair:p){
                board[pair.x][pair.y] = '.';
            }
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
