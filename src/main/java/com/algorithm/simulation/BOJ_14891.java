package com.algorithm.simulation;

import java.io.*;
import java.util.*;

public class BOJ_14891 {

    static char[][] board = new char[5][8];

    //실패 코드
/*

    static int[][] tArr = new int[5][8];
    static boolean[] isUsed = new boolean[5];

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 1; i < 5; i++) {
            String[] sArr = br.readLine().split("");
            for (int j = 0; j < 8; j++) {
                tArr[i][j] = Integer.parseInt(sArr[j]);
            }
        }

        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());

            boolean isRevert = dir != 1;

            func(number, isRevert);
        }

        int result = 0;
        for (int i = 1; i < 5; i++) {
            if(tArr[i][0] == 1) result += Math.pow(2, i-1);
        }

        System.out.println(result);
    }

    static void func(int num, boolean isRevert){
        if(num == 0 || num > 4){
            return;
        }
        int[] arr = tArr[num];
        int[] arrL = new int[8];
        int[] arrR = new int[8];
        if(num == 1){
            arrR = tArr[num + 1];
        }else if(num == 4){
            arrL = tArr[num - 1];
        }else{
            arrR = tArr[num + 1];
            arrL = tArr[num - 1];
        }

        if(!isUsed[num]){

            //양 옆의 톱니바퀴의 값이 다르면 회전
            isUsed[num] = true;
            func(num-1, !isRevert);
            func(num+1, !isRevert);

            if(isRevert){   // 역방향
                if(num != 4){
                    if(arr[2] != arrR[6]){ //오른쪽이 같지 않다면 회전
                        int temp = arr[arr.length-1];
                        for (int i = 7; i > 0; i--) {
                            arr[i] = arr[i-1];
                        }
                        arr[0] = temp;
                    }
                }
            }else { //정방향
                if(num != 1){
                    if(arrL[2] != arr[6]){ //왼쪽이 같지 않다면 회전
                        int temp = arr[0];
                        for (int i = 0; i < 7; i++) {
                            arr[i] = arr[i+1];
                        }
                        arr[arr.length-1] = temp;
                    }
                }
            }

            isUsed[num] = false;
        }

    }
*/

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 4; i++) {
            board[i] = br.readLine().toCharArray();
        }
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            func(num -1, dir);
        }

        int result = 0;
        for (int i = 0; i < 4; i++) {
            if(board[i][0] == '1') result += Math.pow(2, i);
        }

        System.out.println(result);
    }

    static void func(int num, int dir){
        //배열에 각 톱니의 방향을 넣어준다.
        int[] dirs = new int[4];
        dirs[num] = dir;

        //왼쪽
        int idx = num;  //톱니바퀴 번호
        while(idx > 0 && board[idx][6] != board[idx-1][2]){
            //역방향(-)을 넣어준다.
            dirs[idx-1] = -dirs[idx];
            idx--;
        }

        //오른쪽
        idx = num;
        while(idx < 3 && board[idx][2] != board[idx+1][6]){
            //역방향(-)을 넣어준다.
            dirs[idx+1] = -dirs[idx];
            idx++;
        }

        for (int i = 0; i < 4; i++) {
            if(dirs[i] == -1){
                rotate(false, i);
            }else if(dirs[i] == 1){
                rotate(true, i);
            }
        }
    }

    static void rotate(boolean dir, int num){

        if(dir){ //정방향
            char temp = board[num][7];
            for (int i = 7; i > 0; i--) {
                board[num][i] = board[num][i-1];
            }
            board[num][0] = temp;
        } else { //역방향
            char temp = board[num][0];
            for (int i = 0; i < 7; i++) {
                board[num][i] = board[num][i+1];
            }
            board[num][7] = temp;
        }
    }

}
