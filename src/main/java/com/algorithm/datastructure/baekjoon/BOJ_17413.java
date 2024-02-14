package com.algorithm.datastructure.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        StringBuffer sb = new StringBuffer();
        Stack<Character> stack = new Stack();
        boolean isAngle = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '<'){
                isAngle = true;
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
            } else if (c == '>') {
                isAngle = false;
                sb.append(c);
                continue;
            }

            if (isAngle){
                sb.append(c);
            } else {
                if (c == ' '){
                    while (!stack.isEmpty()){
                        sb.append(stack.pop());
                    }
                    sb.append(' ');
                    continue;
                }else{
                    stack.push(c);
                }
            }

            if (i == s.length() - 1) {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
            }

        }
        System.out.println(sb);
    }
}
