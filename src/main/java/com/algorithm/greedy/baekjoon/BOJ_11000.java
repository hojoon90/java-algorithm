package com.algorithm.greedy.baekjoon;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 그리디와 정렬의 혼합문제
 * 문제를 어떻게 풀어야겠다 까지는 도출 됐는데 구현이 제대로 되지 않음.
 * 우선 순위 큐 라는 것을 처음 봤음. 공부가 필요해보임.
 * 시작과 종료가 묶인 클래스로 배열을 만들어주고 정렬을 해준다.
 * 이때 시작시간 기준으로 오름차순 정렬을 하며, 시작 시간이 같으면 종료시간이 빠른 순으로 해준다.
 * 첫번째 강의의 종료시간을 우선 순위 큐에 넣어준다.
 * for문으로 시작시간과 비교해가며 큐에 차곡차곡 넣는다.
 * 만약 큐의 맨처음 종료시간이 다음 강의의 시작시간과 같거나 작으면 큐에서 제거한다. (수업이 끝나고 새로운 수업을 하기 때문에..?)
 */
//https://www.acmicpc.net/problem/11000
public class BOJ_11000 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int lectureCnt = sc.nextInt();
        ClassTime[] lectureArr = new ClassTime[lectureCnt];

        for (int i = 0; i < lectureCnt; i++) {
            int startTime = sc.nextInt();
            int endTime = sc.nextInt();
            lectureArr[i] = new ClassTime(startTime, endTime);
        }

        // c1.endTime에서 c2.endTime 을 뺐을때 음수이면 c1.endTime 값이 적은 것이므로 앞으로 나오게 된다. 반대로 양수면 값이 크므로 뒤로 밀려난다.
        Arrays.sort(lectureArr, (c1, c2)
                -> c1.startTime == c2.startTime ? c1.endTime - c2.endTime : c1.startTime - c2.startTime);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(lectureArr[0].endTime);
        for (int i = 1; i < lectureCnt; i++) {
            if (pq.peek() <= lectureArr[i].startTime) {
                pq.poll();
            }
            pq.offer(lectureArr[i].endTime);
        }
        System.out.println(pq.size());
    }

    public static class ClassTime {
        int startTime;
        int endTime;

        public ClassTime(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

}
