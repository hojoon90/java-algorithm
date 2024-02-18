package com.algorithm.datastructure.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

//https://www.acmicpc.net/problem/10773
public class BOJ_10773 {

    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
//        useStack();
        useArray();

    }

    private static void useArray() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        int[] stackArr = new int[count];
        int top = 0;
        for (int i = 0; i < count; i++) {
            int N = Integer.parseInt(br.readLine());
            if(N == 0){
                top--;
            }else{
                stackArr[top] = N;
                top++;
            }
        }
        int result = 0;
        for (int i = 0; i < top; i++) {
            result += stackArr[i];
        }
        System.out.println(result);
    }

    private static void useStack() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            int N = Integer.parseInt(br.readLine());
            if(N == 0) {
                stack.pop();
                continue;
            }
            stack.push(N);
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }


        System.out.println(result);
    }


}
