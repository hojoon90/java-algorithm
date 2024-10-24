package com.algorithm.binarysearch;

import java.io.*;
import java.util.*;


public class BOJ_2467 {

    static long[] nArr;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        nArr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        long res1 = 0;
        long res2 = 0;

        for (int i = 0; i < n; i++) {
            long val = nArr[i];
            int st = 0;
            int en = nArr.length-1;
            long min = Long.MAX_VALUE;

            while(st < en){
                int mid = (st+en+1)/2;
                if(nArr[mid] + val < 0 ){
                    st = mid;
                }else if(nArr[mid] + val > 0){
                    en = mid-1;
                }

                if(min > nArr[mid] + val){
                    res1 = val;
                    res2 = nArr[mid];
                    min = val+nArr[mid];
                }
            }
        }

        System.out.println(res1 + " " + res2);

    }


//    static long resultVal(int ){
//
//
//        for (int j = 0; j < n; j++) {
//            if(i == j) continue;
//            long result = val + nArr[j];
//        }
//    }
}
