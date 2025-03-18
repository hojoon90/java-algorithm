package com.algorithm.unclassified;

import java.io.*;
import java.util.*;

public class BOJ_1927 {

    static PriorityQueue<Integer> q = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                Integer poll = q.poll();
                if(poll == null) poll = 0;
                System.out.println(poll);
            }else{
                q.add(num);
            }
        }

    }

}
