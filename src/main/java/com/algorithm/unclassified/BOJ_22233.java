package com.algorithm.unclassified;

import java.io.*;
import java.util.*;

public class BOJ_22233 {

    static Set<String> keyword = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        for(int i = 0; i < n; i++){
            keyword.add(br.readLine());
        }

        for(int i = 0; i < m; i++){
            String[] words = br.readLine().split(",");
            for(int j = 0; j < words.length; j++){
                if(keyword.contains(words[j])){
                    keyword.remove(words[j]);
                }
            }
            System.out.println(keyword.size());
        }

    }

}
