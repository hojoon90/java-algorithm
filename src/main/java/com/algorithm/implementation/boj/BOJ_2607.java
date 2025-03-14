package com.algorithm.implementation.boj;

import java.io.*;

public class BOJ_2607 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        String firstWord = br.readLine();
        int[] firstCnt = getCharCount(firstWord);

        for (int i = 1; i < n; i++) {
            String word = br.readLine();
            int[] wordCnt = getCharCount(word);

            if (isSimilar(firstCnt, wordCnt)) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    // 각 알파벳의 개수를 배열로 저장
    private static int[] getCharCount(String word) {
        int[] count = new int[26];
        for (char c : word.toCharArray()) {
            count[c - 'A']++;
        }
        return count;
    }

    // 두 단어가 유사한지 확인
    private static boolean isSimilar(int[] firstCnt, int[] wordCnt) {
        int addCnt = 0;  // 추가된 문자 개수
        int removeCnt = 0; // 제거된 문자 개수

        for (int i = 0; i < 26; i++) {
            if (firstCnt[i] > wordCnt[i]) {
                removeCnt += firstCnt[i] - wordCnt[i]; // 부족한 문자 개수
            } else if (firstCnt[i] < wordCnt[i]) {
                addCnt += wordCnt[i] - firstCnt[i]; // 초과한 문자 개수
            }
        }

        int totalDiff = removeCnt + addCnt;

        return totalDiff == 0 || totalDiff == 1 || (totalDiff == 2 && removeCnt == 1 && addCnt == 1);
    }
}