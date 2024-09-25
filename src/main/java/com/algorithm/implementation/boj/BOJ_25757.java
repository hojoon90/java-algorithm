package com.algorithm.implementation.boj;

import java.io.*;
import java.util.*;

public class BOJ_25757 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        String play = st.nextToken();
        int cnt = 1;
        if(play.equals("F")) cnt = 2;
        else if(play.equals("O")) cnt = 3;

        int idx = 0;
        int result = 0;

        Set<String> list =  new HashSet<>();
        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        for (int i = 0; i < list.size(); i++) {
            idx++;
            if(idx % cnt == 0){
                idx = 0;
                result++;
            }
        }

        System.out.println(result);

    }

}
