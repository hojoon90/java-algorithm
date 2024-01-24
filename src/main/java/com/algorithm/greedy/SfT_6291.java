package com.algorithm.greedy;

import java.util.*;

/**
 * 백준 11000과 비슷한 문제
 * 다만 여기 문제는 1강의실에 최대한 많은 강의를 할수 있다고 설명되어있다.
 * 즉 단순하게 종료시간과 시작시간이 맞을 때 카운트를 1씩 올려주면 된다.
 * 그러므로 종료시간으로 오름차순 정렬을 하고 강의의 시작시간이 전 강의의 종료시간보다 크거나 같으면 카운트를 올려주고
 * 강의 종료시간을 최신 강의의 종료시간으로 바꿔준다.
 * 너무... 꼬아서 생각하지 말자...
 */
//https://softeer.ai/practice/6291
public class SfT_6291 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int lectureCnt = sc.nextInt();
        ClassTime[] lectureArr = new ClassTime[lectureCnt];

        for (int i = 0; i < lectureCnt; i++) {
            int startTime = sc.nextInt();
            int endTime = sc.nextInt();
            lectureArr[i] = new ClassTime(startTime, endTime);
        }

        int resultCnt = 0;
        int end = 0;

        Arrays.sort(lectureArr, Comparator.comparingInt(c -> c.endTime));


        for(ClassTime time : lectureArr){
            if(time.startTime >= end){
                resultCnt++;
                end = time.endTime;
            }
        }
        System.out.println(resultCnt);
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
