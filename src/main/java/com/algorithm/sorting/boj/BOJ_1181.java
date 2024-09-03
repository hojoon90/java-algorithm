package com.algorithm.sorting.boj;

import java.io.*;
import java.util.*;

public class BOJ_1181 {

    public static void main(String[] args) throws IOException{


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            arr[i] = word;
        }
        String[] distArr = Arrays.stream(arr).distinct().toArray(String[]::new);
        Arrays.sort(distArr, (o1, o2) -> {
            if(o1.length() < o2.length()){
                return -1;
            }else if(o1.length() == o2.length()){
                int m = o1.length();
                for (int i = 0; i < m; i++) {
                    if(o1.charAt(i) < o2.charAt(i)){
                        return -1;
                    }else if(o1.charAt(i) > o2.charAt(i)){
                        return 1;
                    }
                }
            }else{
                return 1;
            }
            return 0;
        });

        for (String a : distArr){
            System.out.println(a);
        }
    }

}
