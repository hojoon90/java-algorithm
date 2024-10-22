package com.algorithm.implementation.boj;

import java.io.*;
import java.util.*;

public class BOJ_17266 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        String[] xArr = br.readLine().split(" ");

        int start =1;
        int end=N;
        int result=0;

        //이분탐색
        while(start <= end) {
            int mid = (start+end)/2;

            int prev = 0;
            for(int i=0;i<M;i++) {
                if(Integer.parseInt(xArr[i])-mid <= prev){
                    prev=Integer.parseInt(xArr[i])+mid;
                }
            }
            boolean check = N - prev <= 0;//n까지 거리가 0이하인지 체크!

            if(check) {
                result=mid;
                end=mid-1;
            }
            else start=mid+1;
        }

        System.out.println(result);

    }

}
