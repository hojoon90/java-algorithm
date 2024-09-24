package com.algorithm.implementation.boj;

import java.io.*;
import java.util.*;

public class BOJ_4659 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String word = br.readLine();
            if(word.equals("end")) break;

            boolean aeiou = false;
            boolean continueWord = true;
            boolean sameWord = true;
            char[] arr = word.toCharArray();
            //a e i o u
            aeiou = checkAeiou(arr);

            //3글자 이상 자모음 판단
            if(arr.length > 2){
                continueWord = wordContinue(arr);
            }

            //두글자 이상 중복 판단
            if(arr.length > 1){
                sameWord = wordSame(arr);
            }

            if(aeiou && continueWord && sameWord){
                System.out.println("<"+word+"> is acceptable." );
            }else{
                System.out.println("<"+word+"> is not acceptable." );
            }


        }

    }

    static boolean checkAeiou(char[] arr){
        for (int i = 0; i < arr.length; i++) {
            if (isVowel(arr[i]))
                return true;
        }
        return false;
    }

    static boolean wordContinue(char[] arr){
        for (int i = 2; i < arr.length; i++) {
            //세개연속 모음이면 false
            if(isVowel(arr[i-2]) && isVowel(arr[i-1]) && isVowel(arr[i])){
                return false;
            }

            //세개연속 자음이면 false;
            if(!isVowel(arr[i-2]) && !isVowel(arr[i-1]) && !isVowel(arr[i])){
                return false;
            }

        }
        return true;
    }

    static boolean wordSame(char[] arr){
        for (int i = 1; i < arr.length; i++) {
            String word = arr[i - 1] + String.valueOf(arr[i]);
            //단어가 같고 ee나 oo가 아니면
            if (arr[i-1] == arr[i] && !(word.equals("ee") || word.equals("oo"))){
                return false;
            }
        }
        return true;
    }

    static boolean isVowel(char c){
        return c == 'a' || c =='e' || c == 'i' || c =='o' || c == 'u';
    }
}
