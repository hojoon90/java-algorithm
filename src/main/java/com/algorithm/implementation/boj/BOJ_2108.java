package com.algorithm.implementation.boj;

import java.io.*;
import java.util.*;

public class BOJ_2108 {

    static int[] checkNum = new int[10001];

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
            checkNum[5000+num]++;
        }

        Arrays.sort(arr);

        int sum = Arrays.stream(arr).sum();
        double avg = (double) sum /n;

        //최빈 계산
        int max = 0;
        for(int i = 0; i < 10000; i++){
            max = Math.max(checkNum[i], max);
        }

        boolean flag = false;
        int mode = 0;
        for(int i = 0; i< 10000; i++){
            if(checkNum[i] == max){
                mode = i - 5000;
                if(flag) break;
                flag = true;
            }
        }

        //평균
        System.out.println(Math.round(avg));
        //중앙
        System.out.println(arr[n/2]);
        //최빈
        System.out.println(mode);
        //범위
        System.out.println(arr[n-1] - arr[0]);
    }

}
