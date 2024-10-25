package com.algorithm.binarysearch;

import java.io.*;
import java.util.*;

public class BOJ_2512 {

    static long[] arr;
    static int t;
    static int m;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());
        arr = new long[t];
        long en = -1;
        String[] sArr = br.readLine().split(" ");
        for(int i = 0; i < t; i++){
            arr[i] = Long.parseLong(sArr[i]);
            en = Math.max(en, arr[i]);
        }

        m = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        long st = 0;
        long mid = 0;
        while(st <= en){
            mid = (st+en)/2; // 상한금액
            if(check(mid) <= m) st = mid+1;
            else en = mid - 1;
        }

        System.out.println(en);

    }

    static long check(long mid){
        long budget = 0;

        for(int i = 0; i < t; i++){
            if(arr[i] > mid) {
                budget+=mid;
            } else{
                budget+=arr[i];
            }
        }

        return budget;
    }
}
