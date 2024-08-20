package com.algorithm.greedy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 강의실 문제랑 거의 유사.
 * 소프티어 문제랑 똑같았고 구현도 거의 잘 했다.
 * 다만 시간 비교를 제대로 처리하지 못했다.
 * 여기서는 가장 많은 회의를 할 수 있는 경우를 찾는 것이므로 종료시간 기준으로 오름차순 정렬을 하여 카운트를 세 주면 된다.
 * 다만 유의할 사항은 종료시간이 동일할 경우는 시작시간 기준으로 정렬을 해주어야 한다.
 * 소프티어 테스트케이스에서는 종료시간이 동일할 경우에 대한 처리가 없었던 것 같다.
 * 무조건 정렬이 같을 경우 어떻게 처리해야 할 것인지에 대한 고민이 필요할 것 같다.
 */
//https://www.acmicpc.net/problem/1931
public class BOJ_1931 {

    public static ArrayList<Time> timeList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int meetCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < meetCnt; i++) {
            String[] split = br.readLine().split(" ");
            Time time = new Time(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
            timeList.add(time);
        }

        timeList.sort((c1, c2)-> c1.end == c2.end ? c1.start - c2.start : c1.end - c2.end);

        int endTime = 0;
        int availableMeetCnt = 0;
        for (Time time : timeList) {
            if(time.start >= endTime){
                endTime = time.end;
                availableMeetCnt++;
            }
        }

        System.out.println(availableMeetCnt);
    }

    public static class Time {
        int start;
        int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    
}
