package com.algorithm.implementation.boj;

import java.io.*;
import java.util.*;

public class BOJ_1157 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] a = br.readLine().toCharArray();

        int[] nArr = new int[100];

        for (int i = 0; i < a.length; i++) {
            char c = Character.toUpperCase(a[i]);
            nArr[c]++;
        }

        int idx = 0;
        int mx = 0;
        for (int i = 65; i < nArr.length; i++) {
            if(nArr[i] > mx){
                mx = nArr[i];
                idx = i;
            }
        }

        int cnt = 0;
        for (int i = 65; i < nArr.length; i++) {
            if(mx == nArr[i]) cnt++;
        }

        if(cnt >= 2){
            System.out.println("?");
        }else{
            System.out.println((char) idx);
        }

    }

}
