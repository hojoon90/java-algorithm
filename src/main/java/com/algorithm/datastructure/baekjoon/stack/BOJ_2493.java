package com.algorithm.datastructure.baekjoon.stack;

import java.io.*;
import java.util.*;

public class BOJ_2493 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[] arr = new int[count];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < s.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        Stack<int[]> stack = new Stack<>();

        for(int i = 0; i < count; i++){
            while(!stack.isEmpty()){
                if(stack.peek()[1] >= arr[i]){
                    System.out.print(stack.peek()[0] + 1 +" ");
                    break;
                }
                stack.pop();
            }
            if(stack.isEmpty()){
                System.out.print("0 ");
            }

            stack.push(new int[] {i, arr[i]});
        }
    }
}
