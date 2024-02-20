package com.algorithm.greedy.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        int[][] boxArr = new int[count][2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < count; i++) {
            boxArr[i][1] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < count; i++) {
            boxArr[i][0] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(boxArr, (o1, o2)->  o2[1] - o1[1]);

        int burn = 0;
        int eat = 0;

        for(int i=0; i<boxArr.length; i++) {
            burn += boxArr[i][0];
            eat = Math.max(eat, burn + boxArr[i][1]);
        }

        System.out.println(eat);
    }



}
