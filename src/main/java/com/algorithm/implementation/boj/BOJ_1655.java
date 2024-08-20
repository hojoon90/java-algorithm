package com.algorithm.implementation.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

//https://www.acmicpc.net/problem/1655
public class BOJ_1655 {

    public static ArrayList<Integer> sayList = new ArrayList<>();
    public static ArrayList<Integer> answerList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count ; i++) {
            int say = Integer.parseInt(br.readLine());
            sayList.add(say);
            if (i == 0) {
                answerList.add(say);
                continue;
            }

            Collections.sort(sayList);
            if (sayList.size() % 2 == 0) {  // 짝수
                int compareIdx = sayList.size()/2;
                Integer i1 = answerList.get(i - 1);
                int compare2 = sayList.get(compareIdx - 1);

                int result = Math.min(compare2, i1);

                answerList.add(result);
            }else{  //  홀수
                int answerIdx = sayList.size() / 2;
                answerList.add(sayList.get(answerIdx));
            }

        }

        answerList.stream().forEach(i -> System.out.println(i));
    }
}
