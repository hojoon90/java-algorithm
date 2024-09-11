package com.algorithm.study.retryqueue.retry00;

import java.io.*;
import java.util.*;

/*
https://www.acmicpc.net/problem/18808
 */
public class BOJ_18808 {
/*
    static int[][] notebook;
    static int[][] notebook2;
    static int[][] sticker;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        notebook = new int[N][M];

        int K = Integer.parseInt(st.nextToken());
        for(int stk = 0; stk < K; stk++){
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            sticker = new int[R][C];

            for(int i = 0; i < R; i++){
                String[] sArr = br.readLine().split(" ");
                for (int j = 0; j < C; j++) {
                    sticker[i][j] = Integer.parseInt(sArr[j]);
                }
            }

            //스티커를 붙일수 있는지 Notebook 검색
            boolean possible = isPossible(M, N);
        }


    }

    private static boolean isPossible(int M, int N) {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int i1 = notebook[j][i];
                if(i1 != 0 && i1 == sticker[j][i]){
                    return false;
                }
            }
        }
        return true;
    }

    static void rotate(int R, int C){
        int[][] tmp = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                tmp[i][j] = sticker[i][j];
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sticker[i][j] = tmp[R-1-j][i];
            }
        }

    }
*/
    static int[][] note = new int[42][42];
    static int[][] sticker;
    static int n, m, k, r, c;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            sticker = new int[12][12];
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            for (int j = 0; j < r; j++) {
                st = new StringTokenizer(br.readLine());
                for (int l = 0; l < c; l++) {
                    sticker[j][l] = Integer.parseInt(st.nextToken());
                }
            }

            for (int j = 0; j < 4; j++) {
                boolean isPaste = false;
                for (int x = 0; x <= n - r; x++) {
                    for (int y = 0; y <= m - c; y++) {
                        if(pastable(x,y)){
                            isPaste = true;
                            break;
                        }
                    }
                    if(isPaste) break;
                }
                if(isPaste) break;
                rotate();
            }
        }
        int val = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                val+=note[i][j];
            }
        }
        System.out.println(val);

    }

    static boolean pastable(int x, int y){
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(note[x+i][y+j] == 1 && sticker[i][j] == 1)
                    return false;
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(sticker[i][j] == 1)
                    note[x+i][y+j] = 1;
            }
        }
        return true;
    }

    static void rotate(){
        int[][] tmp = new int[12][12];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                tmp[i][j] = sticker[i][j];
            }
        }

        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                sticker[i][j] = tmp[r-1-j][i];
            }
        }

        int tmp2 = c;
        c = r;
        r = tmp2;
    }

}
