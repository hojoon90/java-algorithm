package com.algorithm.datastructure.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1920 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int c1 = Integer.parseInt(br.readLine());
        int[] c1Arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int c2 = Integer.parseInt(br.readLine());
        int[] c2Arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(c1Arr);
        for (int i = 0; i < c2Arr.length; i++) {
            int i1 = Arrays.binarySearch(c1Arr, c2Arr[i]);
            if(i1 >= 0){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }


    }

}
