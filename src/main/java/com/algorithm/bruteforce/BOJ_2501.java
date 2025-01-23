package com.algorithm.bruteforce;

import java.io.*;
import java.util.*;

public class BOJ_2501 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> pList = new ArrayList<>();

        for(int i = 1; i <= n; i++){
            if(n % i == 0) {
                pList.add(i);
            }
        }

        if(pList.size() <= k-1){
            System.out.println(0);
        }else{
            System.out.println(pList.get(k-1));
        }
    }

}
