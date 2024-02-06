package com.algorithm.greedy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 순간 문제를 이해하지 못해서 헷갈린 문제 (받을 잔돈에 포함된 잔돈의 개수... 가 이해가지 않았다)
 * 전형적인 잔돈 그리디이다.
 *
 * 첫째줄에 들어오는 수는 물건의 가격이다. 구해야 하는 수는 1000엔에서 구매한 금액을 뺀 나머지 금액을 잔돈으로 받을때의 최소 동전개수이다.
 * 반복문을 통해 금액을 동전 만큼 나눈 몫을 저장해두고 돈을 차감해가면서 동전의 개수를 구해주면 된다.
 */
//https://www.acmicpc.net/problem/5585
public class BOJ_5585 {

    public static int[] coins = {500, 100, 50, 10, 5, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int money = 1000 - Integer.parseInt(br.readLine());
        int result = 0;
        for (int i = 0; i < coins.length; i++) {
            if(money == 0) break;
            if(money < coins[i]) continue;
            int change = money / coins[i];
            result += change;
            money -= change * coins[i];
        }

        System.out.println(result);

    }

}
