package com.algorithm.etc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//https://www.acmicpc.net/problem/2460
public class BOJ_2460 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int maxPeople = 0;
        int currentPeople = 0;
        for (int i = 0; i < 10; i++) {
            int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int minus = s[0];
            int plus = s[1];

            int temp = (currentPeople - minus) + plus;
            if (temp > maxPeople) {
                maxPeople = temp;
            }
            currentPeople = temp;
        }
        System.out.println(maxPeople);

    }
}
