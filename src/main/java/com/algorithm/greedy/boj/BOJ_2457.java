package com.algorithm.greedy.boj;

import java.io.*;
import java.util.*;

public class BOJ_2457 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Pair[] flower = new Pair[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startMonth = Integer.parseInt(st.nextToken());
            int startDay = Integer.parseInt(st.nextToken());
            int endMonth = Integer.parseInt(st.nextToken());
            int endDay = Integer.parseInt(st.nextToken());

            flower[i] = new Pair(startMonth*100 + startDay, endMonth*100 + endDay);     //날짜를 최대 1000단위로 표현 (ex 8월 31일 -> 831)
        }

        int result = 0;
        int t = 301;   //3월 1일
        while(t < 1201/* or t <= 1130*/){
            int next_t = t;
            for (int i = 0; i < n; i++) {
                //꽃이 피는 일자가 피길 원하는 날짜보다 작거나 같고, 끝나는 날짜가 다음 꽃이 피는 날짜보다 작으면?
                if(flower[i].st <= t && flower[i].et > next_t){
                    //시작 지점에서 가장 오래 피는 꽃을 고른다.
                    next_t = flower[i].et;
                }
            }
            if(next_t == t){
                System.out.println(0);
                return;
            }
            result++;
            t = next_t; //꽃이 하나 끝나는 이후 시점으로 시간 세팅.
        }
        System.out.println(result);
    }

    static class Pair{
        int st;
        int et;

        public Pair(int st, int et) {
            this.st = st;
            this.et = et;
        }
    }
}
