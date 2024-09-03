package com.algorithm.sorting.boj;

import java.io.*;
import java.util.*;

public class BOJ_2910 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] ordArr = new int[n];
        for (int i = 0; i < n; i++) {
            ordArr[i] = Integer.parseInt(st.nextToken());
        }

        int[] distArr = Arrays.stream(ordArr).distinct().toArray();
        List<Integer> tmp = new ArrayList<>();
        for (int i :distArr) {
            tmp.add(i);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if(map.containsKey(ordArr[i])){
                int upCnt = map.get(ordArr[i])+1;
                map.put(ordArr[i], upCnt);
            }else{
                map.put(ordArr[i], 1);
            }
        }

        Collections.sort(tmp, (o1, o2)->{
                    if(map.get(o1) < map.get(o2)){
                        return 1;
                    }else if(map.get(o1) == map.get(o2)){
                        return 0;
                    }else{
                        return -1;
                    }
                });

        for(int i : tmp){
            for (int j = 0; j < map.get(i); j++) {
                sb.append(i+" ");
            }
        }

        System.out.println(sb);

    }

}
