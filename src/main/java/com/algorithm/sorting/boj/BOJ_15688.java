package com.algorithm.sorting.boj;

import java.io.*;
import java.util.*;

public class BOJ_15688 {

    static int[] arr = new int[20000001];

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cnt = Integer.parseInt(br.readLine());

        for(int i = 0; i < cnt; i++){
            int num = Integer.parseInt(br.readLine());
            arr[num+1000000] += 1;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] != 0){
                int c = arr[i];
                for (int j = 0; j < c; j++) {
                    sb.append(i-1000000 +"\n");
                }
            }
        }
        System.out.println(sb);
    }

}
