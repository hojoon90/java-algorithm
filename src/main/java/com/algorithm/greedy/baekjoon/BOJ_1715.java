package com.algorithm.greedy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 우선순위 큐를 이용한 그리디 문제.
 * 우선순위 큐에 대해 공부가 좀 더 필요한 부분이다. 이 외에도 스택 혹은 큐에 대해 어떤 시점에서 사용해야 할 지에 대한 정리도 필요해 보인다.
 * 일단 자바에서 우선순위 큐는 낮은 수가 우선순위를 가진다. 그렇기 때문에 큐에서 값을 꺼내올 때 낮은 수부터 나오게 되며,
 * 값이 맨 마지막에 들어갔더라도 값 비교를 통해 낮은 수가 앞으로 나오게 된다.
 * 아래 문제도 이와 동일하게 풀면 된다.
 *
 * 문제는 낮은수부터 차례대로 더한 수를 다시 그 다음수에 넣어서 최소 조합을 찾는 문제이다.
 * 이 문제를 풀려면 앞의 두 수를 더하고, 더한수를 다시 그 다음 수와 더해주어야 하는데 우선정렬 큐를 사용하면 낮은 값부터 꺼내오게 되므로
 * 가장 최소 조합의 수를 구할 수 있게 된다.
 *
 */
//https://www.acmicpc.net/problem/1715
public class BOJ_1715 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int i = 0; i < count; i++) {
            pq.add(Long.parseLong(br.readLine()));
        }

        long result = 0;
        while (pq.size() > 1){
            Long poll1 = pq.poll();
            Long poll2 = pq.poll();

            result += poll1 + poll2;
            pq.add(poll1 + poll2);

        }

        System.out.println(result);

    }
}
