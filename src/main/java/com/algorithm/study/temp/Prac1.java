package com.algorithm.study.temp;

import java.io.*;
import java.util.*;

/*
https://www.acmicpc.net/problem/18808
*/
public class Prac1 {

    static int[][] board = new int[42][42];
    static int[][] sticker;
    static int n,m,k,r,c;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for(int stk = 0; stk < k; stk++){
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            sticker = new int[12][12];

            //스티커 세팅
            for (int i = 0; i < r; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < c; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //스티커를 붙일수 있는지 확인. 방향은 최대 4방향을 돌릴수 있으므로 4번 반복
            for (int i = 0; i < 4; i++) {
                boolean isPaste = false;    //4번 반복하면서 붙일수 있는지 확인하는 플래그
                for (int x = 0; x <= n - r; x++) {   //전체 노트 사이즈 중 스티커 사이즈만큼을 빼준다.(스티커를 붙일수 있는곳은 한정적이므로)
                    for (int y = 0; y <= m - c; y++) {
                        if(isPastable(x, y)){
                            isPaste = true;
                            break;
                        }
                    }
                    if(isPaste) break;  //붙였으면 탈출
                }
                if(isPaste) break;  //붙였으면 탈출
                rotate();
            }
        }
        int val = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                val+=board[i][j];
            }
        }

        System.out.println(val);

    }

    static boolean isPastable(int x, int y){
        //스티커를 붙일수 있는지 확인하는 것이므로 r, c만큼 반복한다.
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                //보드에 이미 붙어있고, 스티커위치랑 동일하면 붙일수 없다 리턴.
                if(board[x+i][y+j] == 1 && sticker[i][j] == 1)
                    return false;
            }
        }

        //여기까지 왔으면 보드에 붙일수 있으므로 보드에 붙여버린다.
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(sticker[i][j]==1)
                    board[x+i][y+j] = 1;
            }
        }
        return true;
    }

    static void rotate(){
        int[][] tmp = new int[12][12];
        //스티커 복사
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                tmp[i][j] = sticker[i][j];
            }
        }
        //스티커 돌리기
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                sticker[i][j] = tmp[r-1-j][i];
            }
        }

        //돌렸으므로 r과 c를 바꿈
        int tmp2 = r;
        r = c;
        c = tmp2;
    }

}
