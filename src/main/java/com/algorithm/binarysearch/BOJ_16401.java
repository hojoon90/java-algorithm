package com.algorithm.binarysearch;

import java.io.*;
import java.util.*;

public class BOJ_16401 {

    static long[] cookie = new long[1000005];
    static long m;
    static long n;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < s.length; i++) {
            cookie[i] = Long.parseLong(s[i]);
        }

        m = arr[0];
        n = arr[1];

        long st = 0;
        long en = 1000000000;

        while(st < en){
            long mid = (st+1+en+1)/2;
            if(check(mid)) st = mid;
            else en = mid-1;
        }

        System.out.println(st);

    }

    static boolean check(long mid){
        long cur = 0;
        for(int i = 0; i < n; i++){
            cur += cookie[i] / mid;
        }
        return cur >= m;
    }

}
