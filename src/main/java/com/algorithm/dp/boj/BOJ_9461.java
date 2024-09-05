package com.algorithm.dp.boj;

import java.io.*;
import java.util.*;

public class BOJ_9461 {

    static long[] d = new long[105];

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        //1,2,3,4,5 까지는 고정 숫자. 그 이후부턴 4 차이나는 값들 끼리 더한다.
        d[1] = 1;
        d[2] = 1;
        d[3] = 1;
        d[4] = 2;
        d[5] = 2;

        for (int num = 0; num < n; num++) {
            int cnt = Integer.parseInt(br.readLine());

            for (int i = 6; i <= cnt; i++) {
                d[i] = d[i-1] + d[i-5];
            }
            System.out.println(d[cnt]);
        }
        
    }

}
