package com.algorithm.implementation.boj;

import java.io.*;
import java.util.*;

public class BOJ_2941 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        int wordLength = 0;
        int idx = 0;
        while(idx < word.length()){
            if(word.length() - idx == 1){
                wordLength++;
                break;
            }
            switch(word.charAt(idx)){
                case 'c':
                    if(word.charAt(idx +1) == '=' || word.charAt(idx + 1) == '-'){
                        wordLength++;
                        idx = idx+2;
                    }else{
                        wordLength++;
                        idx++;
                        break;
                    }
                    break;
                case 'd':
                    if(word.charAt(idx+1) == '-'){
                        wordLength++;
                        idx = idx+2;
                    } else if(idx + 2 < word.length() && word.charAt(idx+1) == 'z' && word.charAt(idx+2) == '='){
                        wordLength++;
                        idx = idx+3;
                    }else{
                        wordLength++;
                        idx++;
                        break;
                    }
                    break;
                case 'l':
                case 'n':
                    if(word.charAt(idx+1) == 'j'){
                        wordLength++;
                        idx = idx+2;
                    }else{
                        wordLength++;
                        idx++;
                        break;
                    }
                    break;
                case 's':
                case 'z':
                    if(word.charAt(idx+1) == '='){
                        wordLength++;
                        idx = idx+2;
                    }else{
                        wordLength++;
                        idx++;
                        break;
                    }
                    break;
                default:
                    wordLength++;
                    idx++;
                    break;
            }
        }
        System.out.println(wordLength);


    }

}
