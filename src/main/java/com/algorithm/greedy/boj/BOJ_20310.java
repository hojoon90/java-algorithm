package com.algorithm.greedy.boj;

import java.io.*;

public class BOJ_20310 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();

        int zeroCnt = 0;
        int oneCnt = 0;

        for (char c : chars) {
            if (c == '0') zeroCnt++;
            else oneCnt++;
        }

        zeroCnt /= 2;
        oneCnt /= 2;

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < chars.length && oneCnt > 0; i++) {
            if (chars[i] == '1') {
                chars[i] = 'X'; // 삭제 처리
                oneCnt--;
            }
        }

        for (int i = chars.length - 1; i >= 0 && zeroCnt > 0; i--) {
            if (chars[i] == '0') {
                chars[i] = 'X'; // 삭제 처리
                zeroCnt--;
            }
        }

        for (char c : chars) {
            if (c != 'X') result.append(c);
        }

        System.out.println(result);
    }

}
