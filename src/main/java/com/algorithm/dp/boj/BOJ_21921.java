package com.algorithm.dp.boj;

import java.io.*;
import java.util.*;

public class BOJ_21921 {

    static int[] d = new int[250005];

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] sArr = br.readLine().split(" ");
        int x = Integer.parseInt(sArr[0]);
        int n = Integer.parseInt(sArr[1]);

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        d[0] = arr[0];
        for(int i = 1; i < x; i++){
            d[i] = d[i-1] + arr[i];
        }

        int max = 0;
        int cnt = 1;
        for(int i = n-1; i < x; i++){
            if(i-n < 0) {
                max = d[i];
                continue;
            }
            int val = d[i] - d[i-n];
            if(val > max){
                max = val;
                cnt = 1;
            }else if(val == max){
                cnt++;
            }
        }

        if(max != 0) {
            System.out.println(max);
            System.out.println(cnt);
        }else{
            System.out.println("SAD");
        }
    }
}