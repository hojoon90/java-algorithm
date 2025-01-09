package com.algorithm.implementation.boj;

import java.io.*;
import java.util.*;

public class BOJ_11866 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= k; i++){
            q.offer(i);
        }

        List<Integer> result = new ArrayList<>();

        while(result.size() != k){
            for(int i = 1; i <= n; i++){
                if(i == n){
                    result.add(q.poll());
                    break;
                }
                q.offer(q.poll());
            }
        }

        System.out.print("<");
        System.out.print(result.toString().replace("[", "").replace("]",""));
        System.out.print(">");

    }

}
