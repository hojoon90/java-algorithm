package com.algorithm.greedy.baekjoon;

import java.util.Scanner;

/**
 * 가격수를 조절해야하는 문제
 * 가격이 5의 나머지로 나뉠때까지 2원짜리 동전을 올려주면 된다.
 * 2원을 먼저 거슬러주고 나머지 5원으로 처리할 수 있는 동전수를 합쳐주면 된다.
 * 줄수 없는 동전(ex 3원)은 2로 계속 차감되므로 price가 음수를 찍는다.
 * 결국 price는 음수로 처리되므로 -1로 리턴
 */
//https://www.acmicpc.net/problem/14916
public class BOJ_14916 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int price = sc.nextInt();
        int coin = 0;

        while (true) {
            if(price % 5 !=0){
                price = price - 2;
                coin ++;
            }

            if (price % 5 == 0) {
                coin += price / 5;
                break;
            }

            if(price < 0) coin = -1;
        }
        System.out.println(coin);
    }
}
