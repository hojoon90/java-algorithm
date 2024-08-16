package com.algorithm.etc.baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_3986 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int wordCnt = Integer.parseInt(br.readLine());
        Stack<String> stack = new Stack<>();

        int resultCnt = 0;
        for (int i = 0; i < wordCnt; i++) {
            int popCnt = 0;

            String text = br.readLine();
            String[] textArr = text.split("");

            for (String word: textArr){
                switch(word){
                    case "A":
                        if(!stack.isEmpty() && stack.peek().equals("A")){
                            stack.pop();
                            popCnt++;
                        }else{
                            stack.push(word);
                        }
                        break;
                    case "B":
                        if(!stack.isEmpty() && stack.peek().equals("B")){
                            stack.pop();
                            popCnt++;
                        }else{
                            stack.push(word);
                        }
                        break;
                }

            }
            if(stack.isEmpty() && popCnt > 0){
                resultCnt++;
            }
            stack.clear();
        }
        System.out.println(resultCnt);

    }


}
