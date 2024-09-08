package com.algorithm.simulation;

import java.io.*;
import java.util.*;

public class BOJ_11559 {

    static char[][] board = new char[12][6];
    static boolean[][] visited = new boolean[12][6];
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static boolean isPop = true;
    static int count;

    //실패코드
    /* 실패 코드

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 12; i++){
            board[i] = br.readLine().toCharArray();
        }

        //탐색후 4개를 찾으면 카운트 1 증가
        //1 증가되면 해당 뿌요는 없어지고 그 위에 있는 뿌요들이 내려옴
        //다시 탐색 반복
        for (int i = 11; i >= 0; i--) {
            for (int j = 0; j < 6; j++) {
                char text = board[i][j];
                if(text != '.'){
                    q.offer(new Pair(i, j));
                    extracted();
                }
                if(popq.size() >= 4) {
                    count++;
                    //내려오는 처리
                    for (int k = 11; k >= 0; k--) {
                        for (int l = 0; l < 6; l++) {
                            if(visited[k][l]) {
                                board[k][l] = '.';
                            }
                        }
                    }


                    size = 0;
                }
            }
        }
        System.out.println(count);
    }

    private static void extracted() {
        while(!q.isEmpty()){
            Pair cur = q.poll();
            visited[cur.x][cur.y] = true;
            char val = board[cur.x][cur.y];

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx >= 12 || nx < 0 || ny >= 6 || ny < 0){
                    continue;
                }

                if(visited[nx][ny] || val != board[nx][ny]){
                    continue;
                }

                q.offer(new Pair(nx, ny));
                popq.offer(new Pair(nx, ny));
                visited[nx][ny] = true;
                size++;
            }
        }
    }
    */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 12; ++i) {
            board[i] = br.readLine().toCharArray();
        }
        while(isPop){
            isPop = false;
            for (int i = 0; i < 6; ++i) {
                for (int j = 10; j >= 0 ; --j) {
                    int temp = j;
                    //뿌요가 내려오는 로직 ( = 보드를 가로로 돌리면 배열의 위치 바꾸는것과 동일 )
                    while(temp < 11 && board[temp+1][i] == '.'){
                        char t = board[temp][i];
                        board[temp][i] = board[temp+1][i];
                        board[temp+1][i] = t;
                        ++temp;
                    }
                }
            }
            for (int i = 0; i < 12; ++i) {
                for (int j = 0; j < 6; ++j) {
                    if(!visited[i][j] && board[i][j] != '.'){
                        bfs(i, j);
                    }
                }
            }
            if(isPop) ++count;
            resetVis();
        }
        System.out.println(count);
    }

    static void resetVis() {
        for (int i = 0; i < 12; ++i) {
            for (int j = 0; j < 6; ++j) {
                visited[i][j] = false;
            }
        }

    }

    static void bfs(int x, int y){
        Queue<Pair> q = new LinkedList<>();
        List<Pair> p = new ArrayList();

        visited[x][y] = true;
        char val = board[x][y];
        q.offer(new Pair(x, y));
        p.add(new Pair(x, y));
        while(!q.isEmpty()){
            Pair cur = q.poll();
            for (int i = 0; i < 4; ++i) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx < 0 || nx >= 12 || ny < 0 || ny >=6){
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

        //뿌요 삭제
        if(p.size() >= 4){
            isPop = true;
            for(Pair pVal: p){
                board[pVal.x][pVal.y] = '.';
            }
        }

    }

    static class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

}
