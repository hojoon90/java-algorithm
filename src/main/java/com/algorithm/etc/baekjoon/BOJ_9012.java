package com.algorithm.etc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//https://www.acmicpc.net/problem/9102
public class BOJ_9012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());


        for (int i = 0; i < count; i++) {
            Stack<Character> stack = new Stack<>();

            String s = br.readLine();
            String result;
            boolean check = false;

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);

                if(c == '(') {
                    stack.push(c);
                }
                if(c == ')' && stack.isEmpty()) {
                    check = true;
                    break;
                }
                if (c == ')') {
                    stack.pop();
                }
            }
            if (!stack.isEmpty() || check) {
                result = "NO";
            }else{
                result = "YES";
            }
            System.out.println(result);
        }
    }
}
