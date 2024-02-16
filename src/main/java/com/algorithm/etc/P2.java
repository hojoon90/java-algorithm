package com.algorithm.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = info[0];    // 길이
        int K = info[1];    // 가져오는 수
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        if(N <= K){
            System.out.println(1);
        }

        int minusCnt = N-K;

        if(minusCnt%(K-1) != 0){
            System.out.println(minusCnt/(K-1) + 2);
        }else{
            System.out.println(minusCnt/(K-1) + 1);
        }



    }


}
