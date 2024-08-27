package com.algorithm.simulation;

import java.io.*;
import java.util.*;

public class BOJ_18808 {

    static int[][] board = new int[42][42];
    static int[][] sticker;
    static int n, m, k, r, c;


    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for(int stk = 0; stk < k; stk++){
            sticker = new int[12][12];
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            //스티커 세팅
            for (int i = 0; i < r; i++) {
                String[] stkStr = br.readLine().split(" ");
                for (int j = 0; j < c; j++) {
                    sticker[i][j] = Integer.parseInt(stkStr[j]);
                }
            }

            //실제 스티커를 붙이는 작업
            for (int i = 0; i < 4; i++) { //방향
                boolean isPaste = false;
                for (int x = 0; x <= n - r; x++) {  //스티커를 붙일 수 있는 위치에 모두 붙여보기 위해 빼준다. board n = 5, r = 3이면, 0,1,2에 붙여볼 수 있기 때문.
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
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cnt += board[i][j];
            }
        }
        System.out.println(cnt+"\n");
    }
    static boolean isPastable(int x, int y){
        //시작위치(x,y)에서 하나씩 올라가면서 스티커가 붙어있으면서, 스티커가 존재하는 칸일 경우 못붙임.
        for(int i = 0; i < r; i++){
            for (int j = 0; j < c; j++) {
                if(board[x+i][y+j] == 1 && sticker[i][j] == 1){
                    return false;
                }
            }
        }
        //위에서 return 안됐으면 붙일 수 있으므로 스티커를 붙임.
        for(int i = 0; i < r; i++){
            for (int j = 0; j < c; j++) {
                if(sticker[i][j] == 1)
                    board[x+i][y+j] = 1;
            }
        }
        return true;
    }

    static void rotate(){
        int[][] temp = new int[12][12];

        //스티커를 temp로 복사
        for(int i = 0; i < r; i++){
            for (int j = 0; j < c; j++) {
                temp[i][j] = sticker[i][j];
            }
        }

        //복사한 temp 스티커를 돌려서 처리
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                sticker[i][j] = temp[r-1-j][i];
            }
        }

        int temp2 = r;
        r = c;
        c = temp2;
    }

}
