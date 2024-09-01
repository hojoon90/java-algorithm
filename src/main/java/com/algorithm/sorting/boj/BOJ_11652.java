package com.algorithm.sorting.boj;

import java.io.*;
import java.util.*;

public class BOJ_11652 {

    public static void main(String[] args) throws IOException{

        int prevCnt = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Long[] arr = new Long[n];
        for(int i = 0; i < n; i++){
            arr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr);

        int cnt = 1;
        long maxVal = arr[0];

        for (int i = 1; i < n; i++) {
            if(arr[i-1] == arr[i]) {
                cnt++;
            } else {
                cnt = 1;
            }
            if(prevCnt < cnt){
                maxVal = arr[i-1];
                prevCnt = cnt;
            }
        }
        System.out.println(maxVal);

    }

}
