package com.algorithm.study.retryqueue.boj0901;

import java.io.*;
import java.util.*;

/*
https://www.acmicpc.net/problem/2504
 */
public class BOJ_2504 {

    static Stack<Character> s = new Stack<>();

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int result = 0;
        int tmp = 1;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == '(') {
                tmp *= 2;
                s.push(c);
            }else if(c == ')') {
                if (s.isEmpty() || s.peek() != '(') {
                    result = 0;
                    break;
                }
                if (str.charAt(i - 1) == '(') {
                    result += tmp;
                }
                s.pop();
                tmp /= 2;
            }else if(c == '[') {
                tmp *= 3;
                s.push(c);
            }else if(c == ']') {
                if(s.isEmpty() || s.peek() != '['){
                    result = 0;
                    break;
                }
                if(str.charAt(i-1) == '['){
                    result += tmp;
                }
                s.pop();
                tmp /= 3;
            }
        }

        if(!s.isEmpty()){
            System.out.println(0);
            return;
        }

        System.out.println(result);
    }

}
