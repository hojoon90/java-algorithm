package com.algorithm.greedy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 정렬 + 우선순위 큐로 접근해야 하는 문제
 * 정렬하는 방법도 어설펐고 for문을 돌면서 전체 보석에 대해 처리하려고 하니 시간초과 문제가 발생했다.
 * 일단 정렬을 할때는 같은 값이 있을 수도 있다는 생각을 하고 정렬을 진행해야 한다. 이번 문제를 풀때는 그러한 고려 없이 정렬을 진행했다.
 * 그리고 정렬을 가격의 역순으로 정렬하고 무게도 역순으로 정렬하여 가장 값비싼 보석부터 담을수 있도록 처리하려 했는데 이 또한 잘못된 접근이었다.
 * 먼저 보석과 가방의 무게를 오름차순(정순)으로 정렬시키고, 큐에다가 가방 무게에 해당하는 가치들을 모두 넣어준다.
 * 반복문이 처리되면서 큐에 있는 보석들을 1개씩 빼오고 값비싼 보석부터 결과값에 더해주게 된다. 이렇게 가방 개수만큼 가장 값비싼 보석을 가져올 수 있게 된다.
 */
public class BOJ_1202 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //br.readLine int로 받기
        int[] countArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = countArr[0];
        int K = countArr[1];

        Jewelry[] jewelryList = new Jewelry[N];
        for (int i = 0; i < N; i++) {
            int[] jInfo = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            jewelryList[i] = new Jewelry(jInfo[0], jInfo[1]);
        }

        Arrays.sort(jewelryList, (o1, o2) -> o1.weight == o2.weight ? o2.price - o1.price : o1.weight - o2.weight);

        int[] bagArr = new int[K];
        for (int i = 0; i < K; i++) {
            bagArr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bagArr);

        long result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0, j = 0; i < K; i++) {
            while (j < N && jewelryList[j].weight <= bagArr[i]) {
                pq.offer(jewelryList[j++].price);
            }

            if (!pq.isEmpty()) {
                result += pq.poll();
            }
        }

        System.out.println(result);
    }

    public static class Jewelry {
        int weight;
        int price;

        public Jewelry(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }
    }


}
