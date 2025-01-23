package com.algorithm.bruteforce;

import java.io.*;
import java.util.*;

public class BOJ_2309 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[9];
        int result = 0;
        for(int i = 0; i < 9; i++){
            arr[i] = Integer.parseInt(br.readLine());
            result += arr[i];
        }

        Arrays.sort(arr);

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 9; j++){
                if(result-(arr[i]+arr[j]) == 100){
                    for(int k = 0; k < 9; k++){
                        if(k != i && k != j){
                            System.out.println(arr[k]);
                        }
                    }
                    return;
                }
            }
        }

    }

}
