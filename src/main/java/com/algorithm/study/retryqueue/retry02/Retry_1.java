package com.algorithm.study.retryqueue.retry02;

import java.io.*;
import java.util.*;

/*
https://www.acmicpc.net/problem/2504
 */
public class Retry_1 {

    static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = br.readLine().toCharArray();

        int sum = 0;
        int num = 1;

        for(int i = 0; i < arr.length; i++){
            if (arr[i] == '(') {
                num *= 2;
                stack.push(arr[i]);
            }

            if(arr[i] == ')'){
                if(stack.isEmpty() || stack.peek() != '('){
                    sum = 0;
                    break;
                }
                if(arr[i -1] == '(') sum += num;
                num /= 2;
                stack.pop();
            }

            if(arr[i] == '['){
                num *= 3;
                stack.push(arr[i]);
            }

            if(arr[i] == ']'){
                if(stack.isEmpty() || stack.peek() != '['){
                    sum = 0;
                    break;
                }
                if(arr[i - 1] == '[') sum += num;
                num /= 3;
                stack.pop();
            }
        }
        if(!stack.isEmpty()) System.out.println(0);
        else System.out.println(sum);
    }

}
