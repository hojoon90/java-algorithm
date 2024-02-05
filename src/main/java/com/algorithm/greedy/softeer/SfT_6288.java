package com.algorithm.greedy.softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 백준 12865 문제와 같은 배낭문제인 줄 알고 바로 DP로 접근했다가 실패한 문제.
 * https://namu.wiki/w/%EB%B0%B0%EB%82%AD%20%EB%AC%B8%EC%A0%9C 여기에 잘 나와 있는데,
 * 이 문제는 '분할 가능한 배낭 문제'이다. 즉, 필요한 만큼 나머지를 채워서 최대한의 값을 뽑아내면 된다.
 * 그리디 알고리즘으로 풀 수 있는 문제이다.
 *
 * 먼저 주어진 보석들의 무게와 가치를 리스트에 저장해준다.
 * 그리고 가치가 높은 순대로 역순 정렬 후 계산해주면 된다.
 * 계산할 때는 제일 높은 가치 먼저 계산 하고 계산된 무게만큼 총 무게에서 빼준다.
 * 그리고나서 남은 보석이 들수 있는 무게보다 높을 경우 남은 무게 * 가치만큼 곱해서 최대 값으로 가져오면 된다.
 * 막상 코드를 보고 나니 쉬웠던 문제...
 */
//https://softeer.ai/practice/6288
public class SfT_6288 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tk = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(tk.nextToken());
        int N = Integer.parseInt(tk.nextToken());

        ArrayList<int[]> jewelyList = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            tk = new StringTokenizer(br.readLine());
            jewelyList.add(new int[]{
                    Integer.parseInt(tk.nextToken()),   // 무게
                    Integer.parseInt(tk.nextToken())    // 가치
            });
        }

        Collections.sort(jewelyList, (c1, c2) -> c2[1] - c1[1]);  //가치가 높은 순으로 정렬

        int result = 0;

        for (int[] jewely : jewelyList) {
            //만약 주어진 무게가 W보다 크면 W 만큼 해당 가치를 곱해주고 return
            if (W <= jewely[0]) {
                result += W * jewely[1];
                break;
            } else {
                result += jewely[0] * jewely[1];
                W -= jewely[0];
            }
        }

        System.out.println(result);
    }

}
