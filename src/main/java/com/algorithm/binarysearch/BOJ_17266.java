package com.algorithm.binarysearch;

import java.io.*;

public class BOJ_17266 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        String[] xArr = br.readLine().split(" ");

        int start = 1;
        int end = N;
        int result = 0;

        //이분탐색
        while (start <= end) {
            int height = (start + end) / 2;

            int prev = 0;
            for (int i = 0; i < M; i++) {
                int light = Integer.parseInt(xArr[i]);
                if (light - height <= prev) {
                    prev = light + height;
                }
            }
            boolean check = N - prev <= 0; //n까지 거리가 0이하인지 체크!

            if (check) {
                result = height;
                end = height - 1;
            } else start = height + 1;
        }

        System.out.println(result);

    }

}
