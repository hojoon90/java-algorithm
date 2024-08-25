package com.algorithm.etc.boj;

import java.io.*;
import java.util.*;

public class BOJ_2504 {

    static Stack<Character> st = new Stack<>();

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] brackets = br.readLine().toCharArray();

        long sum = 0;
        long num = 1;

        for(int i = 0; i < brackets.length; i++){
            switch(brackets[i]){
                case '(': {
                    num *= 2;
                    st.push(brackets[i]);
                    break;
                }
                case ')': {
                    if(st.isEmpty() || st.peek() != '(') {
                        System.out.println(0);
                        return;
                    }
                    if(brackets[i-1] == '(') sum += num;
                    st.pop();
                    num /= 2;
                    break;
                }
                case '[': {
                    num *= 3;
                    st.push(brackets[i]);
                    break;
                }
                case ']': {
                    if(st.isEmpty() || st.peek() != '[') {
                        System.out.println(0);
                        return;
                    }
                    if(brackets[i-1] == '[') sum += num;
                    st.pop();
                    num /= 3;
                    break;
                }
                default: {

                }
            }

        }
        System.out.println(sum);

    }
}
