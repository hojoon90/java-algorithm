package com.algorithm.array.boj;

import java.io.*;

public class BOJ_10808 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] countArr = new int[26];
        String[] word = br.readLine().split("");

        for(String alphabet: word){
            int ascii = alphabet.charAt(0);
            int idx = ascii - 'a';

            countArr[idx] += 1;
        }

        for(int i: countArr){
            System.out.print(i+ " ");
        }

    }
}
