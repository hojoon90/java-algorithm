package com.algorithm.etc.baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_4949 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String text = br.readLine();
            if(text.equals(".")) break;

            Stack<Character> stack = new Stack<>();

            for(int i = 0; i < text.length(); i++){
                char word = text.charAt(i);
                switch(word){
                    case '(':
                        stack.push(word);
                        break;
                    case '[':
                        stack.push(word);
                        break;
                    case ')':
                        if(!stack.isEmpty() && stack.peek().equals('(')){
                            stack.pop();
                        }else{
                            stack.push(word);
                        }
                        break;
                    case ']':
                        if(!stack.isEmpty() && stack.peek().equals('[')){
                            stack.pop();
                        }else{
                            stack.push(word);
                        }
                        break;
                    default:
                        break;
                }

            }

            if(stack.isEmpty()){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }


    }


}
