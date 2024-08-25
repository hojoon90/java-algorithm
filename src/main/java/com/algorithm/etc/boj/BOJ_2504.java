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
            if(brackets[i] == '(') {
                num *= 2;
                st.push(brackets[i]);
            } else if( brackets[i] ==  ')') {
                if(st.isEmpty() || st.peek() != '(') {
                    sum = 0;
                    break;
                }
                if(brackets[i-1] == '(') sum += num;
                st.pop();
                num /= 2;
            }
            else if( brackets[i] ==   '[') {
                num *= 3;
                st.push(brackets[i]);
            }
            else if( brackets[i] ==   ']') {
                if(st.isEmpty() || st.peek() != '[') {
                    sum = 0;
                    break;
                }
                if(brackets[i-1] == '[') sum += num;
                st.pop();
                num /= 3;
            }

        }
        if(!st.isEmpty()) System.out.println(0);
        else System.out.println(sum);

    }
}
