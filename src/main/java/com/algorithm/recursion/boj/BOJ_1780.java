package com.algorithm.recursion.boj;

import java.io.*;
import java.util.*;

public class BOJ_1780 {

    static int [][] paper;
    static int [] numCnt = new int[3];

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        paper = new int[count][count];
        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < count; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        func(0, 0, count);

        System.out.println(numCnt[0]);
        System.out.println(numCnt[1]);
        System.out.println(numCnt[2]);
    }

    static void func(int x, int y, int count){
        //base case 는 나눈 종이가 모두 동일할 때.
        if(check(x,y,count)) {
            numCnt[paper[x][y] + 1] += 1;
            return;
        }
        int dt = count / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                func(x + i*dt, y + j*dt, dt);
            }
        }

    }

    static boolean check(int x, int y, int count){
        for (int i = x; i < x + count; i++) {
            for (int j = y; j < y + count; j++) {
                if(paper[x][y] != paper[i][j])
                    return false;
            }
        }
        return true;
    }

}
