package com.algorithm.datastructure.boj;

import java.io.*;
import java.util.*;

public class BOJ_1620 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = arr[0];
        int m = arr[1];
        String[] pokeArr = new String[n];
        Map<String, String> pokeMap = new HashMap<>();

        for (int i = 0; i < n; i++){
            String pokeName = br.readLine();
            pokeArr[i] = pokeName;
            pokeMap.put(pokeName, String.valueOf(i+1));
        }

        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            if(isInteger(s)){
                int idx = Integer.parseInt(s);
                sb.append(pokeArr[idx-1]).append("\n");
            }else{
                String s1 = pokeMap.get(s);
                sb.append(s1).append("\n");
            }
        }
        System.out.println(sb);
    }

    static boolean isInteger(String br){
        try{
            Integer.parseInt(br);
            return true;
        }catch(NumberFormatException ne){
            return false;
        }
    }
}
