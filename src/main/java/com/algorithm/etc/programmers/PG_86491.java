package com.algorithm.etc.programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PG_86491 {

    public static void main(String[] args) {

        int[][] test1 = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        System.out.println(solution(test1));

    }

    public static int solution(int[][] sizes) {
        int answer = 0;

        int wMax = 0;
        int hMax = 0;

        for (int i = 0; i < sizes.length; i++) {
            int[] value = sizes[i];
            //사이즈가 크면 위치를 바꿔준다
            if(value[1] > value[0]){
                int temp = value[0];
                value[0] = value[1];
                value[1] = temp;
            }

            if(value[0] > wMax) wMax = value[0];
            if(value[1] > hMax) hMax = value[1];

        }

        answer = wMax * hMax;

        return answer;
    }

}
