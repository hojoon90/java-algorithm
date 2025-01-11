package com.algorithm.sorting.boj;

import java.io.*;
import java.util.*;

public class BOJ_2751 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> answerList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            int k = Integer.parseInt(br.readLine());
            answerList.add(k);
        }

        Collections.sort(answerList);

        for(int i = 0; i < answerList.size(); i++){
            sb.append(answerList.get(i)+"\n");
        }

        System.out.println(sb);
    }

}
