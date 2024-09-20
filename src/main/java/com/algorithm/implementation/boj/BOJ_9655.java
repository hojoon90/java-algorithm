package com.algorithm.implementation.boj;

import java.io.*;
import java.util.*;

public class BOJ_9655 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean isSk = false;

        while(n != 0){
            if(n < 3){
                n -= 1;
            }else{
                n -= 3;
            }
            isSk = !isSk;
        }

        if(isSk) System.out.println("SK");
        else System.out.println("CY");

    }

}
