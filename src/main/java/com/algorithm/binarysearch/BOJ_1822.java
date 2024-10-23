package com.algorithm.binarysearch;

import java.io.*;
import java.util.*;

public class BOJ_1822 {

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] cntArr = br.readLine().split(" ");
        int n = Integer.parseInt(cntArr[0]);
        int m = Integer.parseInt(cntArr[1]);

        long[] nArr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long[] mArr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        Arrays.sort(nArr);
        Arrays.sort(mArr);
        List<Long> result = new ArrayList<>();

        for(int i = 0; i < n; i++){
            long val = nArr[i];
            long search = Arrays.binarySearch(mArr, val);
            if(search < 0){
                result.add(val);
            }
        }

        Collections.sort(result);
        if(result.isEmpty()){
            sb.append(0);
        }else{
            sb.append(result.size()).append("\n");
            for(long i : result){
                sb.append(i).append(" ");
            }

            System.out.println(sb);
        }
    }
}
