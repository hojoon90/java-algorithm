package com.algorithm.datastructure.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1834 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int count = Integer.parseInt(br.readLine());
        int[] arr = new int[count];

        int idx = 0;
        int stackPoint = 0;

        for (int i = 0; i < count; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num > stackPoint) {
                for (int j = stackPoint + 1; j <= num; j++) {
                    arr[idx] = j;
                    idx++;
                    sb.append("+").append("\n");
                }
                stackPoint = num;
            } else if(arr[idx - 1] != num){
                System.out.println("NO");
                return;
            }

            idx--;
            sb.append("-").append("\n");
        }

        System.out.println(sb);
    }

}
