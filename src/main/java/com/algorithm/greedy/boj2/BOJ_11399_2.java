package com.algorithm.greedy.boj2;

import java.io.*;
import java.util.*;

public class BOJ_11399_2 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] rArr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int result = 0;
        for (int i = 0; i < n; i++) {
            int time = 0;
            for (int j = n - i -1; j >= 0 ; j--) {
                time += arr[j];
            }
            rArr[i] = time;
        }

        for (int i = 0; i < n; i++) {
            result += rArr[i];
        }
        System.out.println(result);
    }

}
