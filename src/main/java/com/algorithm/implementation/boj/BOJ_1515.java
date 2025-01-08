package com.algorithm.implementation.boj;

import java.io.*;

/**
 * 각 자리 숫자는 최대 1~10 까지 존재.
 * base - 실제 지워지기 전 숫자.
 * point - 숫자를 찾은 후 옮겨가는 인덱스
 * 원래있던 숫자를 찾으면 point가 증가하면서 한칸 올라간다.
 * 여기서 최솟값은 있던 숫자 리스트중 가장 최소로 만들수 있는 값..?
 */
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
