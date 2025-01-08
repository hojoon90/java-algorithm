package com.algorithm.implementation.boj;

import java.io.*;
import java.util.*;

public class BOJ_9881 {

    static int[] arr;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int max = 0;
        int min = Integer.MAX_VALUE;
        arr = new int[n];
        for(int i = 0; i < n; i++){
            int hill = Integer.parseInt(br.readLine());
            max = Math.max(hill, max);
            min = Math.min(hill, min);
            arr[i] = hill;
        }

        int answer = Integer.MAX_VALUE;
        for(int i = min; i < max-17; i++){
            answer = Math.min(answer, calc(i, i+17, n));
        }
        if(answer == Integer.MAX_VALUE) {
            System.out.println(0);
        }else{
            System.out.println(answer);
        }

    }

    static int calc(int min, int max, int n){
        int result = 0;
        for(int i = 0; i < n; i++){
            int temp = 0;
            if(arr[i] > max){
                temp = (int) Math.pow(arr[i] - max, 2);
            }else if(arr[i] < min){
                temp = (int) Math.pow(min - arr[i], 2);
            }
            result += temp;
        }
        return result;
    }

}
