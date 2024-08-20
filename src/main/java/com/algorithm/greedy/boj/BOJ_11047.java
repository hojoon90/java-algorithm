package com.algorithm.greedy.boj;

import java.util.Scanner;

/**
 * 전형적인 그리디 동전 문제.
 * 첫번째 동전 단위는 무조건 1이므로 정확하게 나누어 떨어지게 할 수 있다.
 * 그렇기에 가장 큰 단위로 거슬러줄 수 있는 동전부터 바꿔서 넘겨주면 된다.
 * 난이도 치고는 쉬운 문제
 */

//https://www.acmicpc.net/problem/11047
public class BOJ_11047 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int coinCnt = sc.nextInt();
        int price = sc.nextInt();
        int[] coins = new int[coinCnt];
        int resultCnt = 0;

        for (int i = coinCnt - 1; i >= 0; i--) {
            coins[i] = sc.nextInt();
        }

        for (Integer coin: coins) {
            int value = price / coin;
            if(value != 0 ){
                resultCnt += value;
                price = price % coin;
            }
        }
        System.out.println(resultCnt);
    }

}
