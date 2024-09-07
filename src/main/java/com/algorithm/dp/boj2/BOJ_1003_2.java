package com.algorithm.dp.boj2;

import java.io.*;
import java.util.*;

public class BOJ_1003_2 {

    static int[] d = new int[45];

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        d[1] = 1;
        //d[n] = d[n-1] + d[n-2]
        for (int i = 2; i <= 40; i++) {
            d[i] = d[i-1] + d[i-2];
        }

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) System.out.println("1 0");
            else System.out.println(d[n-1]+" "+d[n]);
        }
    }

}
