package com.algorithm.implementation.boj;

import java.io.*;
import java.util.*;

public class BOJ_2960 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];
        for(int i = 2; i <= n; i++){
            arr[i] = i;
        }

        for(int i = 2; i<= n; i++){
            if(arr[i] == 0) continue;

            //해당값의 배수만큼 늘어남
            for(int j = i; j <= n; j+=i){
                if(arr[j] != 0){
                    arr[j] = 0;
                    k--;
                    if(k == 0){
                        System.out.println(j);
                        break;
                    }
                }
            }

        }



    }
}
