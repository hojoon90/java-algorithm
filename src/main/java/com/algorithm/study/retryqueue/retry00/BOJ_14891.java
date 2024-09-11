package com.algorithm.study.retryqueue.retry00;

import java.io.*;
import java.util.*;

/*
https://www.acmicpc.net/problem/14891
 */
public class BOJ_14891 {

    //실패코드 (접근까지는 괜찮았음)
/*
    static int[][] t = new int[5][8];
    static int[][] resultT = new int[5][8];
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 1; i <= 4; i++) {
            t[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int no = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            boolean isAsc = dir == 1 ? true : false;

            for (int j = no; j <= 4; j++) {
                //회전
                if(no != 1 && t[no-1][2] != t[no][6]){
                    if(isAsc) moveAsc(no);
                    else moveDesc(no);
                }

                if(no != 4 && t[no][2] != t[no+1][6]){
                    if(isAsc) moveAsc(no);
                    else moveDesc(no);
                }
                isAsc = !isAsc;
            }


            isAsc = dir == 1 ? true : false;
            for (int j = no; j > 0; j--) {
                //회전
                if(no != 1 && t[no-1][2] != t[no][6]){
                    if(isAsc) moveAsc(no);
                    else moveDesc(no);
                }

                if(no != 4 && t[no][2] != t[no+1][6]){
                    if(isAsc) moveAsc(no);
                    else moveDesc(no);
                }
                isAsc = !isAsc;
            }
        }

        int result = 0;
        for (int i = 1; i <= 4; i++) {
            if(t[i][0] == 1) {
                result += (int) Math.pow(2,i-1);
            }
        }

        System.out.println(result);

    }

    static void moveDesc(int no){
        int[] tmp = new int[8];
        int[] tm = t[no];

        for (int i = 0; i < 8; i++) {
            tmp[i] = tm[i];
        }

        int first = tmp[0];
        for (int i = 0; i < 7; i++) {
            tmp[i] = tmp[i+1];
        }
        tmp[7] = first;

        for (int i = 0; i < 8; i++) {
            resultT[no][i] = tmp[i];
        }
    }

    static void moveAsc(int no){
        int[] tmp = new int[8];
        int[] tm = t[no];

        for (int i = 0; i < 8; i++) {
            tmp[i] = tm[i];
        }

        int last = tmp[7];
        for (int i = 7; i > 0; i--) {
            tmp[i] = tmp[i-1];
        }
        tmp[0] = last;

        for (int i = 0; i < 8; i++) {
            resultT[no][i] = tmp[i];
        }
    }
    */

    static char[][] t = new char[5][8];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            t[i] = br.readLine().toCharArray();
        }
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int no = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            rotate(no - 1, dir);
        }
        int result = 0;
        for (int i = 0; i < 4; i++) {
            if(t[i][0] == '1') {
                result += (int) Math.pow(2,i);
            }
        }

        System.out.println(result);

    }

    private static void rotate(int no, int dir) {
        int[] dirArr = new int[4];
        dirArr[no] = dir;
        int idx = no;
        while(idx > 0 && t[idx][6] != t[idx-1][2]){
            dirArr[idx-1] = -dirArr[idx];
            idx--;
        }

        idx = no;
        while(idx < 3 && t[idx][2] != t[idx+1][6]){
            dirArr[idx+1] = -dirArr[idx];
            idx++;
        }

        for (int i = 0; i < 4; i++) {
            if(dirArr[i] == -1){
                move(i, false);
            }else if(dirArr[i] == 1){
                move(i, true);
            }
        }
    }

    static void move(int no, boolean asc){

        if(asc){
            char first = t[no][7];
            for (int i = 7; i > 0; i--) {
                t[no][i] = t[no][i-1];
            }
            t[no][0] = first;
        }else{
            char last = t[no][0];
            for (int i = 0; i < 7; i++) {
                t[no][i] = t[no][i+1];
            }
            t[no][7] = last;
        }

    }


}
