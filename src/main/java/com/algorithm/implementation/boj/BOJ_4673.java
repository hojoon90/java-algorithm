package com.algorithm.implementation.boj;

import java.io.*;
import java.util.*;

public class BOJ_4673 {

    static boolean[] isSelf = new boolean[20000];

    public static void main(String[] args) throws IOException{

        for(int i = 1; i <= 10000; i++){
            dFunc(i);
        }

        for(int i =1; i < 10000; i++){
            if(!isSelf[i]) System.out.println(i);
        }

    }

    static void dFunc(int num){
        String s = String.valueOf(num);
        int idx;
        if(s.length() > 1) {
            idx = num;
            String[] sArr = s.split("");
            for(int i = 0; i < sArr.length; i++){
                idx+=Integer.parseInt(sArr[i]);
            }
        }else{
            idx = num + num;
        }
        if(!isSelf[idx]) isSelf[idx] = true;
    }


}
