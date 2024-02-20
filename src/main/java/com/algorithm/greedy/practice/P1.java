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

        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            boxArr[i][1] = Integer.parseInt(st.nextToken());
            boxArr[i][0] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(boxArr, (o1, o2)-> o2[1] == o1[1] ? o1[0] - o2[0] : o1[1] - o2[1]);

        int burn = 0;
        int eat = 0;

        for(int i=0; i<boxArr.length; i++) {
            burn += boxArr[i][0];
            eat = Math.max(eat, burn + boxArr[i][1]);
        }

        System.out.println(eat);
    }



}
