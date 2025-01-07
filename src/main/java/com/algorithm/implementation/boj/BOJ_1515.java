package com.algorithm.implementation.boj;

import java.io.*;

public class BOJ_1515 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int point = 0;
        int base = 0;
        while(base++ <= 30000){
            String tmp = String.valueOf(base);
            for(int j = 0; j < tmp.length(); j++){
                if(tmp.charAt(j) == s.charAt(point)){
                    point++;
                }
                if(point == s.length()){
                    System.out.println(base);
                    return;
                }
            }

        }


    }
}
