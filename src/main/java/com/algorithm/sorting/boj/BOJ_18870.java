package com.algorithm.sorting.boj;

import java.io.*;
import java.util.*;

public class BOJ_18870 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        int[] answer = new int[n];
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            answer[i] = num;
        }

        Arrays.sort(answer);

        HashMap<Integer, Integer> map = new HashMap<>();
        int rank = 0;
        for(int i = 0; i < n; i++){
            int k = answer[i];
            if(!map.containsKey(k)){
                map.put(k, rank);
                rank++;
            }
        }

        for(int i : arr){
            sb.append(map.get(i)).append(" ");
        }

        System.out.println(sb);

    }

}
