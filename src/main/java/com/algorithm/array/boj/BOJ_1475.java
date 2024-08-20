package com.algorithm.array.boj;

import java.io.*;

public class BOJ_1475 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] numArr = new int[10];
        String[] roomNo = br.readLine().split("");

        for(String s: roomNo){
            if(s.equals("6") || s.equals("9")){
                numArr[9] += 1;
            }else{
                numArr[Integer.parseInt(s)] += 1;
            }
        }

        numArr[9] = numArr[9]/2 + numArr[9]%2;

        int result = 0;
        for(int i: numArr){
            result = Math.max(result, i);
        }

        System.out.println(result);
    }
}
