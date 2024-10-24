package com.algorithm.binarysearch;

import java.io.*;
import java.util.*;

public class BOJ_2805 {

    static long n;
    static long m;
    static long[] woodArr = new long[1000005];

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        n = arr[0];    // 나무 수
        m = arr[1];    // 필요한 높이

        String[] sArr = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            woodArr[i] = Long.parseLong(sArr[i]);
        }

        long st = 0;    //절단기 높이
        long en = 1000000000;

        while(st < en){
            long mid = (st+1+en+1)/2; //절단기 조절 높이
            if(check(mid)) st = mid;
            else en = mid - 1;
        }

        System.out.println(st);

    }

    static boolean check(long mid){
        long current = 0;
        for (int i = 0; i < n; i++) {
            long cut = woodArr[i] - mid;
            if(cut >= 0) current += cut;
        }

        return current >= m;
    }

}
