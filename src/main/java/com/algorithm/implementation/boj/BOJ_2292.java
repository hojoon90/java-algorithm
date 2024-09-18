package com.algorithm.implementation.boj;

import java.io.*;
import java.util.*;

public class BOJ_2292 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt =1;
        int r = 2;  //다음 원의 시작 위치

        if(n == 1) {
            System.out.println(1);
        }
        else {
            while(r <= n){
                r = r + (6 * cnt);
                cnt++;
            }
            System.out.println(cnt);
        }
    }

}
