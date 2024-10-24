package com.algorithm.sorting.boj;

import java.io.*;
import java.util.*;

public class BOJ_20920 {

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);

        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            String word = br.readLine();
            if(word.length() < m) continue;
            if(map.containsKey(word)){
                map.put(word, map.get(word) + 1);
            }else{
                map.put(word, 1);
            }
        }

        List<String> words = new ArrayList<>(map.keySet());
        Collections.sort(words);
        words.sort((o1, o2) -> {
            //서로 안같으면
            if(map.get(o1).compareTo(map.get(o2)) != 0){
                return map.get(o2).compareTo(map.get(o1));
            }

            if(o1.length() != o2.length()){
                return o2.length() - o1.length();
            }

            return o1.compareTo(o2);

        });

//        int cnt = 0;
//        for(String s : map.keySet()){
//            int wCnt = map.get(s);
//            if(wCnt > cnt) {
//                words.add(0, words.remove(words.indexOf(s)));
//                cnt = wCnt;
//            }
//        }

        for(String s : words){
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }


}
