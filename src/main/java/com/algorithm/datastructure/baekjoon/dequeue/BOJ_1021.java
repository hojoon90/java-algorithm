package com.algorithm.datastructure.baekjoon.dequeue;

import java.io.*;
import java.util.*;

/**
 * 좌측 또는 우측으로 움직이기 위해선 리스트의 중간값을 갖고 비교 한다.
 * 중간에서 좌 우 비교 후 가장 짧은 값을 처리.
 */
public class BOJ_1021 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int allNum = Integer.parseInt(st.nextToken());
        int wantCnt = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] wantNum = new int[wantCnt];
        for(int i = 0; i < wantCnt; i++){
            wantNum[i] = Integer.parseInt(st.nextToken());
        }

        LinkedList<Integer> deque = new LinkedList<>();
        for(int i = 1; i <= allNum; i++){
            deque.add(i);
        }

        int resultCnt = 0;
        for(int num : wantNum){

            int idx = deque.indexOf(num);
            int halfIdx;

            if(deque.size() % 2 == 0){
                halfIdx = deque.size() / 2 - 1;
            }else{
                halfIdx = deque.size() / 2;
            }

            if(idx > halfIdx){

                for (int i = 0; i < deque.size() - idx; i++) {
                    deque.offerFirst(deque.pollLast());
                    resultCnt++;
                }

            } else {

                for (int i = 0; i < idx; i++) {
                    deque.offerLast(deque.pollFirst());
                    resultCnt++;
                }

            }

            deque.pollFirst();
        }

        System.out.println(resultCnt);
    }
}
