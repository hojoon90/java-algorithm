package com.algorithm.simulation;

import java.io.*;
import java.util.*;

public class BOJ_10431 {
    
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[20];
            
            int tCase = Integer.parseInt(st.nextToken());
            for(int j = 0; j < 20; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int result = 0;
            for (int j = 0; j < 20; j++) {
                for (int k = 0; k < j; k++) {
                    if(arr[j] < arr[k]) result++;
                }
            }

            System.out.println(tCase+" "+result);
        }
        
    }
    
}
