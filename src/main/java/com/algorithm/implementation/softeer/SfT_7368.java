package com.algorithm.implementation.softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SfT_7368 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);
        int d = Integer.parseInt(s[2]);

        int startCnt = d;
        int backCnt = d;
        int totalCnt = 0;

        while (startCnt >= 0) {
            if (startCnt - a > 0) {
                totalCnt += a;
                totalCnt += b;
            } else {
                totalCnt += startCnt;
            }
            startCnt = startCnt - a;
        }

        while (backCnt >= 0){
            if (backCnt - b > 0) {
                totalCnt += b;
                totalCnt += a;
            } else {
                totalCnt += backCnt;
            }
            backCnt = backCnt - b;
        }

        System.out.println(totalCnt);
    }
}
