package com.algorithm.etc.boj;

import java.io.*;
import java.util.*;

public class BOJ_10799 {

    static Stack<Character> st = new Stack<>();

    public static void main(String[] args) throws IOException{

        long result = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String pipeStr = br.readLine();
        int size = pipeStr.length();
        char[] pipeArr = pipeStr.toCharArray();
        for(int i = 0; i < size; i++){
            if(pipeArr[i] == '('){
                st.push(pipeArr[i]);
            }else{
                if(pipeArr[i-1] == '('){ //레이저
                    st.pop(); //파이프 인줄 알고 넣었던 값을 빼줌
                    result += st.size(); //파이프의 끝에 닿기 전에 레이저에 잘렸으므로 그 개수만큼 더해준다.
                }else{ //파이프 끝일 때
                    st.pop();
                    result++; //파이프의 끝이므로 하나 올려준다.
                }
            }
        }

        System.out.println(result);

    }

}
