package com.algorithm.unclassified;

import java.io.*;
import java.util.*;

public class SWEA_22574 {

    static long[] d = new long[1000000005];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int tCase = 0; tCase < t; tCase++) {
            String[] sArr = br.readLine().split(" ");
            int N = Integer.parseInt(sArr[0]);
            int P = Integer.parseInt(sArr[1]);

            for (int i = 1; i <= N; i++) {
                d[i] = d[i - 1] + i;
                if (d[i] == P) {
                    d[i] -= i;
                    if (i > 1) {
                        d[i] = Math.max(d[i - 1], d[i - 2] + i);
                    }
                }
            }
            System.out.println(d[N]);

//            long tmp = 0;
//            for (int i = 1; i <= N; i++) {
//                tmp += i;
//                if(tmp == P){
//                    tmp -= i;
//                    if(i > 1){
//                        tmp = Math.max(tmp - (i-1), tmp - (i-1 + i-2) + i);
//                    }
//                }
//            }
//            System.out.println(tmp);
        }
    }

}

