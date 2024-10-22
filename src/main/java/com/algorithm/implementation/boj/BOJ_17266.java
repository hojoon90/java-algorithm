package com.algorithm.implementation.boj;

import java.io.*;
import java.util.*;

public class BOJ_17266 {

    static int[] road;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        String[] xArr = br.readLine().split(" ");
        //가로등의 비출수 있는 앞뒤 수가 N보다 커야한다.
        boolean allShow = false;
        int h = 1;
        road = new int[N+1];
        while(true){
            for(int i = 0; i < M; i++){
                int x = Integer.parseInt(xArr[i]);
                int back = x-h;
                int front = x+h;
                if(back < 0) back = 0;
                if(front > N) front =N;

                for (int j = back; j <= front; j++) {
                    road[j] = 1;
                }
            }

            for(int i = 0; i <= N; i++){
                allShow = true;
                if(road[i] == 0){
                    allShow = false;
                    break;
                }
            }
            if(allShow) break;
            road = new int[N+1];
            h++;
        }

        System.out.println(h);
    }

}
