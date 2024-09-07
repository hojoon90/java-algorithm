package com.algorithm.greedy.boj;

import java.io.*;
import java.util.*;

public class BOJ_1541 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] mArr = br.readLine().split("-");

        int result = 0;
        for (int i = 0; i < mArr.length; i++) {
            int sum = Arrays.stream(mArr[i].split("\\+")).mapToInt(Integer::parseInt).sum();

            if(i == 0){
                result = sum;
            }else{
                result -= sum;
            }
        }

        System.out.println(result);

    }

}
