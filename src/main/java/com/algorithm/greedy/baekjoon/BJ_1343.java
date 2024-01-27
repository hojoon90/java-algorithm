package com.algorithm.greedy.baekjoon;

import java.util.Scanner;

/**
 * 쉽게 생각하자.. 단순하게 글자만 replace 해주면 되는 문제
 * replace를 다 하고도 X가 남을 경우는 나눠지지 않는 값이므로 -1로 리턴
 * 굳이 배열로 필요값을 담고, .으로 split 하고 할 필요가 없음
 * 너무 꼬아서 생각해서 제대로 못 푼 문제
 */
//https://www.acmicpc.net/problem/1343
public class BJ_1343 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String board = sc.next();
        String result = "";

        String A = "AAAA";
        String B = "BB";

        board = board.replace("XXXX", A);
        result = board.replace("XX", B);

        if(result.contains("X")) result = "-1";

        System.out.println(result);
    }
}
