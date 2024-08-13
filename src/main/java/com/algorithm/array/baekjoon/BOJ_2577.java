package com.algorithm.array.baekjoon;

import java.io.*;

public class BOJ_2577 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] numberArr = new int[10];

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        String[] result = String.valueOf(a*b*c).split("");

        for(String s : result){
            numberArr[Integer.parseInt(s)] += 1;
        }

        for(int i: numberArr){
            System.out.println(i);
        }
    }
}
