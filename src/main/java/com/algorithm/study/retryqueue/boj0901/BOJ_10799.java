package com.algorithm.study.retryqueue.boj0901;

import java.io.*;
import java.util.*;

/*
https://www.acmicpc.net/problem/10799
 */
public class BOJ_10799 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int tmp = 0;
        int result = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == '('){
                tmp += 1;
            }else {
                tmp -=1;
                if(str.charAt(i-1) == '('){
                    result += tmp;
                }else{
                    result += 1;
                }
            }

        }

        System.out.println(result);


    }

}
