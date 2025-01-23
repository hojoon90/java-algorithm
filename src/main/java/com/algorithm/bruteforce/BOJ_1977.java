package com.algorithm.bruteforce;

import java.io.*;
import java.util.*;

public class BOJ_1977 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int min = -1;
        int sum = 0;
        for(int i = 1; i <= 100; i++){
            int num = i*i;
            if(num >= m && num <= n){
                if(min == -1) min = num;
                sum += num;
            }

        }

        if(min == -1){
            System.out.println(min);
            return;
        }

        System.out.println(sum);
        System.out.println(min);


    }

}
