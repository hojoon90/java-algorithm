package com.algorithm.dp.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 너무 생 코딩에 쓸데 없는 부분으로 시간을 빼앗김
 * 층수는 0층부터, 호수는 1층부터 시작한다.
 * 그렇기 때문에 제공해주는 층수 +1 (배열을 만들면 0부터 시작이므로 제공하는 층수까지 쓰려면 +1을 해주어야 한다.)
 * 그리고 호수 +1 (호수는 0부터 시작하는데, 조건에 각 호수i에 i만큼의 인원이 있다고 한다. 즉 0호 = 0, 1호 = 1, 2호 = 2... 이런식으로. 그러므로 제공하는 호수에 맞추려면 +1한다.)
 * 를 해준다.
 * 그러고 난 후 주어진 층의 호수는 아래층의 해당 호수 전체를 더한 수 이므로 for문을 통해서 인원들을 모두 더하고 처리해주면 된다.
 * +1 처리때문에 애먹은 문제.
 */
//https://www.acmicpc.net/problem/2775
public class BOJ_2775 {

    public static int[][] apt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCnt; i++) {
            int floor = Integer.parseInt(br.readLine());
            int ho = Integer.parseInt(br.readLine());
            apt = new int[floor+1][ho+1];
            for (int j = 0; j <= ho; j++) {
                apt[0][j] = j;
            }

            for (int j = 1; j <= floor; j++) {
                for (int k = 0; k <= ho; k++) {
                    int people = 0;
                    for (int l = 0; l <= k; l++) {
                        people += apt[j-1][l];
                    }
                    apt[j][k] = people;
                }
            }
            System.out.println(apt[floor][ho]);
        }

    }
}
