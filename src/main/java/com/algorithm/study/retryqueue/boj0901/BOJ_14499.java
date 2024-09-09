package com.algorithm.study.retryqueue.boj0901;

import java.io.*;
import java.util.*;

/*
https://www.acmicpc.net/problem/14499
 */
public class BOJ_14499 {

    //실패코드
/*
    static int[][] board = new int[21][21];
    static int[] dice = new int[1001];

    static int[] south = {3,2,1,4};
    static int[] north = {3,4,1,2};
    static int[] west = {5,2,4,6};
    static int[] east = {6,2,5,4};

    static int[] mx = {1,0,-1,0};
    static int[] my = {0,1,0,-1};

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int k = Integer.parseInt(st.nextToken());

        int nx = 0;
        int ny = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int v = Integer.parseInt(st.nextToken());
                if(v == 0) {
                    nx = i;
                    ny = j;
                }
                board[i][j] = v;
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int dir = Integer.parseInt(st.nextToken());
            switch(dir){
                case 1:{    // 동
                    int v = board[nx][ny + 1];

                }
                case 2:{    // 서
                    board[nx][ny-1]
                }
                case 3:{    // 북
                    board[nx-1][ny]
                }
                case 4:{    // 남
                    int i1 = board[nx + 1][ny];


                }
            }

        }




    }
*/


    static int[][] board = new int[21][21];
    static int[] dice = new int[7];
    //굴러가는 방향들을 배열로 만들어준다.
    static int[][] roll = {
            {},
            {2,6,4,5}, //동(1) 5->2, 2->6, 6->4, 4->5
            {2,5,4,6}, //서(2) 6->2, 2->5, 5->4, 4->6
            {3,2,1,4}, //북(3) 4->3, 3->2, 2->1, 1->4
            {2,3,4,1}  //남(4) 1->2, 2->3, 3->4, 4->1
    };
    static int n, m, x, y, k;


    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int cmd = Integer.parseInt(st.nextToken());

            int nx = x;
            int ny = y;

            if(cmd == 1) ny++;
            else if(cmd == 2) ny--;
            else if(cmd == 3) nx--;
            else nx++;

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
        int[] tmp = new int[7];
        for (int i = 1; i <= 6; i++) {
            tmp[i] = dice[i];
        }

        for (int i = 0; i < 4; i++) {
            tmp[roll[cmd][i]] = dice[roll[cmd][(i+1)%4]];
        }

        for (int i = 1; i <=6 ; i++) {
            dice[i] = tmp[i];
        }
    }

}
