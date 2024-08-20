package com.algorithm.etc.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//https://www.acmicpc.net/problem/2501
public class BOJ_2501 {

    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = 0;
        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = s[0];
        int K = s[1];

        for (int i = 1; i <= N; i++) {
            if(N%i == 0){
                list.add(i);
            }
        }

        Collections.sort(list);
        if (K <= list.size()) result = list.get(K - 1);
        System.out.println(result);
    }

}
