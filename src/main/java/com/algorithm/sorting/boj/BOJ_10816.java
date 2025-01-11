package com.algorithm.sorting.boj;

import java.io.*;
import java.util.*;

public class BOJ_10816 {

    static int[] baseArr = new int[20000001];

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++){
            int k = Integer.parseInt(st.nextToken());
            baseArr[10000000+k]++;
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < m; i++){
            int k = Integer.parseInt(st.nextToken());
            System.out.print(baseArr[10000000+k]+" ");
        }




    }

}
