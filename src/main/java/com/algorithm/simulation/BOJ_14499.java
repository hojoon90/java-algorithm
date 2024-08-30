package com.algorithm.simulation;

import java.io.*;
import java.util.*;

public class BOJ_14499 {

    //실패코드
/*
    static int[][] board = new int[20][20];
    static int[][] dice = new int[4][4];
    static int[] dx = {0,0,-1,1};   //동서북남
    static int[] dy = {1,-1,0,0};   //동서북남
    static Queue<Pair> q  = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int k = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            String[] sArr = br.readLine().split(" ");
            for(int j = 0; j < m; j++){
                int val = Integer.parseInt(sArr[j]);
                if(val == 0) q.offer(new Pair(i, j));
                board[i][j] = val;
            }
        }

        //커맨드 처리
        //위, 아래 이동은 주사위 배열의 두번째(가운데)열에 저장.
        //양 옆 이동은 주사위 배열의 두번째 행에 저장.
        int columnIdx = 0;   //세로 인덱스
        int rowIdx = 0;   //가로 인덱스
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int cmd = Integer.parseInt(st.nextToken()) - 1;
            Pair cur = q.poll();
            int nx = cur.x + dx[cmd];
            int ny = cur.y + dy[cmd];

            //보드를 벗어나면 명령 무시
            if(nx < 0 || nx >= n || ny < 0 || ny >= m){
                q.offer(new Pair(cur.x, cur.y));
                continue;
            }
            int boardNum = board[nx][ny];

            if(cmd == 0 || cmd == 1){
                //idx + 2 = 윗면
                rowIdx++;
                rowIdx %= 4;
                if(boardNum != 0 && dice[1][rowIdx] == 0){
                    dice[1][rowIdx] = boardNum;
                    board[nx][ny] = 0;
                }else if(boardNum == 0){
                    board[nx][ny] = dice[1][rowIdx];
                }
                int showHIdx = (rowIdx + 2) % 4;
                sb.append(dice[1][showHIdx] + "\n");
            }else{
                columnIdx++;
                columnIdx %= 4;
                if(boardNum != 0 && dice[columnIdx][1] == 0){
                    dice[columnIdx][1] = boardNum;
                    board[nx][ny] = 0;
                }else if(boardNum == 0){
                    board[nx][ny] = dice[columnIdx][1];
                }
                int showVIdx = (columnIdx + 2) % 4;
                sb.append(dice[showVIdx][1] + "\n");
            }

            q.offer(new Pair(nx, ny));
        }

        System.out.println(sb);
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

    static int n, m, x, y;
    static int[][] board = new int[21][21];
    static int[] dice = new int[7];
    /*   [1]
    * [5][2][6]
    *    [3]
    *    [4]
    */
    static int[][] roll = {
            {},
            {2,6,4,5},
            {2,5,4,6},
            {3,2,1,4},
            {2,3,4,1}
    };

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        int k = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            String[] sArr = br.readLine().split(" ");
            for(int j = 0; j < m; j++){
                int val = Integer.parseInt(sArr[j]);
                board[i][j] = val;
            }
        }

        //커맨드 처리
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int cmd = Integer.parseInt(st.nextToken());
            int nx = x;
            int ny = y;

            if(cmd == 1) ny++;
            else if(cmd == 2) ny--;
            else if(cmd == 3) nx--;
            else nx++;

            //보드를 벗어나면 명령 무시
            if(nx < 0 || nx >= n || ny < 0 || ny >= m){
                continue;
            }

            x = nx;
            y = ny;
            rollDice(cmd);

            if(board[nx][ny] == 0){
                board[nx][ny] = dice[4];
            }else{
                dice[4] = board[nx][ny];
                board[nx][ny] = 0;
            }
            System.out.println(dice[2]);
        }

    }

    static void rollDice(int cmd){
        //위에 세팅해둔 인덱스 값에 맞춰서 둘아간 값이 저장된다.
        int[] tmp = new int[7];
        for (int i = 1; i <= 6; i++) {
            tmp[i] = dice[i];
        }

        for (int i = 0; i < 4; i++) {
            tmp[roll[cmd][i]] = dice[roll[cmd][(i+1)%4]];
        }

        for (int i = 1; i <= 6; i++) {
            dice[i] = tmp[i];
        }
    }

}
