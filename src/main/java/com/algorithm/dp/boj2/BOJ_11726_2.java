package com.algorithm.dp.boj2;

import java.io.*;
import java.util.*;

public class BOJ_11726_2 {

    static int[] d = new int[1005];

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        //d[n] = d[n-1]+d[n-2]
        d[1] = 1;
        d[2] = 2;

        for (int i = 3; i <= cnt; i++) {
            d[i] = (d[i-1] + d[i-2]) % 10007;
        }

        System.out.println(d[cnt]);

    }

}
