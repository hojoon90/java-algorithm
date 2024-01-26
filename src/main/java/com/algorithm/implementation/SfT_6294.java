package com.algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 구현? 문제
 * 난이도 치고는 풀이가 쉬웠던 문제.
 * 배열을 구간별로 나누는 메서드와 소수점 변환 메서드만 조금 까다로웠고 나머지는 무난하게 풀이할 수 있었다.
 */

//https://softeer.ai/practice/6294
public class SfT_6294 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        //학생수
        int studentCnt = Integer.parseInt(str[0]);
        //섹션 수
        int sectionCnt = Integer.parseInt(str[1]);

        //점수 배열
        String[] scoreArr = br.readLine().split(" ");
        int[] scoreIntArr = new int[studentCnt];
        for (int i = 0; i < studentCnt; i++) {
            scoreIntArr[i] = Integer.parseInt(scoreArr[i]);
        }

        //평균계산
        for (int i = 0; i < sectionCnt; i++) {
            String[] sectionArr = br.readLine().split(" ");
            int startSection = Integer.parseInt(sectionArr[0])-1;
            int endSection = Integer.parseInt(sectionArr[1]);

            int[] sectionScoreArr = Arrays.copyOfRange(scoreIntArr, startSection, endSection);
            float allCnt = Arrays.stream(sectionScoreArr).sum();

            float avg = allCnt / sectionScoreArr.length;
            System.out.println(String.format("%.2f", avg));
        }

    }


}
