package com.algorithm.etc.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/10828
public class BOJ_10828 {

    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int commandCnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < commandCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int count = 0;
            if(st.hasMoreElements()) count = Integer.parseInt(st.nextToken());
            process(command, count);
        }

    }

    public static void process(String command, int count){
        switch (command){
            case "push" : {
                stack.push(count);
                break;
            }
            case "pop" : {
                System.out.println(stack.isEmpty() ? -1 : stack.pop());
                break;
            }
            case "size": {
                System.out.println(stack.size());
                break;
            }
            case "top" : {
                System.out.println(stack.isEmpty() ? -1 : stack.peek());
                break;
            }
            case "empty" : {
                System.out.println(stack.isEmpty() ? 1 : 0);
                break;
            }
        }
    }

}
