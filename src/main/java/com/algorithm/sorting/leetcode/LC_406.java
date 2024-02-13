package com.algorithm.sorting.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 나보다 큰 사람이 앞에 몇명이 있을 지 정렬하는 문제.
 * 문제에서 정렬로 처리해야 할 것 같아서 일단 정렬로 접근하였다. 하지만 제대로 정렬하지 못해서 결국은 답을 확인한 문제...
 * 주어진 배열들은 내 키(i[0])와 내 앞에 나보다 키가 크거나 같은 사람의 숫자(i[1])가 담겨있는데, 결국은 i[1]의 위치가 맞게 정렬해주면 된다.
 * 그러기 위해선 일단 제일 키큰 사람부터 역순으로 정렬을 먼저 해준다. 만약 키가 서로 같으면 뒤의 숫자순서대로 정렬해준다.
 * 예시인 [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]] 에서는 다음과 같이 정렬된다.
 * [[7,0],[7,1],[6,1],[5,0],[5,2],[4,4]]
 *
 * 그 후 다시 재정렬 해주는데, 뒤의 i[1]의 숫자는 해당 배열이 리스트에 들어갈 인덱스 위치라고 생각하면 된다.
 * 왜냐면 키가 작을수록 앞에 존재하는 사람이 많을 테고, i[1]의 숫자가 올라갈 가능성이 높다. 그렇기에 i[0]을 먼저 정렬하여 키가 큰 사람들 부터 세팅해주고
 * 키가 작은 사람들을 넣어주면 숫자에 알맞게 정렬이 된다.
 *
 * 생각보다 기본문제 같지만 생각을 잘 해야하는 문제다...
 */

//https://leetcode.com/problems/queue-reconstruction-by-height/description/
public class LC_406 {

    public static void main(String[] args) throws IOException {

        //이중배열 받아서 처리하는 법
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String arrayStr = br.readLine();
        arrayStr = arrayStr.substring(1, arrayStr.length() - 1);

        String[] splitStr = arrayStr.split("],\\[");
        int[][] newArr = new int[splitStr.length][2];

        for (int i = 0; i < splitStr.length; i++) {
            String[] numStr = splitStr[i].split(",");
            newArr[i][0] = Integer.parseInt(numStr[0].replace("[", ""));
            newArr[i][1] = Integer.parseInt(numStr[1].replace("]", ""));
        }

        int[][] ints = reconstructQueue(newArr);

        for (int[] val : ints) {
            for (int v : val) {
                System.out.print(v + " ");
            }
            System.out.println("");
        }
    }

    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> o1[0] != o2[0] ? o2[0] - o1[0] : o1[1] - o2[1]);
        List<int[]> list = new ArrayList<>();
        for (int[] i : people) {
            list.add(i[1], i);
        }
        return list.toArray(new int[people.length][]);
    }
}
