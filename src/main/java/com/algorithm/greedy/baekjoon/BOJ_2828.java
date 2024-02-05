package com.algorithm.greedy.baekjoon;

import java.util.Scanner;

/**
 * 필드에 바구니를 이동시켜 사과를 담는 문제
 * 필드 수는 필드를 안넘어가게 하기 위해 주는 값 같은데 딱히 필요가 없었다..
 * 이동관련이 나오니 손을 못대서 못푼 문제.
 * 핵심은 바구니의 크기에 따라 위치값을 잘 조정해주는 것이다.
 * 어쨌든 사과는 왼쪽이든 오른쪽이든 끝부분에만 걸치면 되므로 이동 방향을 잘 정해서 사과가 떨어지는 곳에 끝부분을 위치시키면 된다.
 * 오른쪽 이동 -> 사과의 위치가 오른쪽 포인트보다 크다.
 * 왼쪽 이동 -> 사과의 위치가 왼쪽 포인트보다 작다.
 * 이 포인트를 찾아서 바구니를 움직이는 카운트를 세어주면 된다.
 */
//https://www.acmicpc.net/problem/2828
public class BOJ_2828 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 필드 수
        int M = sc.nextInt(); // 바구니 사이즈

        int leftP = 1;   // 바구니 위치 인덱스
        int rightP = M; // 바구니 위치 인덱스

        int totalMove = 0;
        int appleCnt = sc.nextInt();
        for (int i = 0; i < appleCnt; i++) {
            int apple = sc.nextInt();

            if (leftP > apple){ //왼쪽으로 움직여야함
                totalMove += leftP - apple;
                rightP -= leftP - apple;
                leftP = apple;
            } else if (rightP < apple) {    // 오른쪽으로 움직여야함
                totalMove += apple - rightP;
                leftP += apple - rightP;
                rightP = apple;
            }
        }
        System.out.println(totalMove);
    }
}
