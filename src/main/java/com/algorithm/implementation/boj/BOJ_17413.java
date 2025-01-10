package com.algorithm.implementation.boj;

import java.io.*;
import java.util.*;

public class BOJ_17413 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        String word = br.readLine();
        char[] wordArr = word.toCharArray();
        boolean isTag = false;

        for(int i = 0; i < wordArr.length; i++) {
            if (wordArr[i] == '<'){
                isTag = true;
                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }

                sb.append(wordArr[i]);
            } else if(wordArr[i] == '>'){
                isTag = false;
                sb.append(wordArr[i]);
            }else if(isTag){
                sb.append(wordArr[i]);
            }else{
                if(wordArr[i] == ' '){
                    while(!stack.isEmpty()){
                        sb.append(stack.pop());
                    }

                    sb.append(wordArr[i]);
                }else{
                    stack.push(wordArr[i]);
                }
            }
        }
        while( !stack.isEmpty() ) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }

}
