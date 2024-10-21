package com.algorithm.implementation.boj;

import java.io.*;
import java.util.*;

public class BOJ_9017 {

    static int[] lastIdx;
    static int[] userCnt;
    static int[] scoreArr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int tCase = 0; tCase < t; tCase++){
            lastIdx = new int[1001];
            userCnt = new int[1001];
            scoreArr = new int[1001];

            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            String[] tArr = br.readLine().split(" ");
            for(int i = 0; i < N; i++){
                int M = Integer.parseInt(tArr[i]);
                arr[i] = M;
                userCnt[M]++;   //유저 카운트
            }

            //유효한 팀 필터링
            List<Integer> verified = new ArrayList<>();
            for(int i = 0; i < 200; i++){
                if(userCnt[i] == 6){
                    verified.add(i);
                }
            }

            //유효하지 않은 팀은 점수가 없으므로 없는 팀 자리는 0으로 세팅
            int score = 1;
            for (int i = 0; i < N; i++) {
                int num = arr[i];
                if(verified.contains(num)){
                    scoreArr[i] = score;
                    score++;
                }
            }

            //만약 유효한 팀이 1팀이면 그팀만 1등이므로 바로 리턴
            if(verified.size() == 1) {
                System.out.println(verified.get(0));
                continue;
            }

            Map<Integer, Integer> result = new HashMap<>();
            for (Integer i: verified){
                int cnt = 0;
                result.put(i, 0);
                for (int j = 1; j <= N; j++) {
                    //각 팀의 점수 비교. 마지막 주자 확인을 위해 마지막 인덱스값은 저장해둔다.
                    if(arr[j-1] == i){
                        cnt++;
                        if(cnt == 5) {
                            lastIdx[i] = j-1;
                            break;
                        }
                        result.put(i, result.get(i) + scoreArr[j-1]);
                    }
                }
            }

            //점수 비교
            int minCnt = Integer.MAX_VALUE;
            int minTeam = 0;
            for(Integer i : verified){
                int teamCnt = result.get(i);
                if(teamCnt == minCnt) {
                    int minTeamScore = scoreArr[lastIdx[minTeam]];
                    int compareTeamScore = scoreArr[lastIdx[i]];
                    if(minTeamScore > compareTeamScore){
                        minTeam = i;
                    }
                }
                else {
                    if(minCnt > teamCnt){
                        minTeam = i;
                        minCnt = teamCnt;
                    }
                }
            }

            System.out.println(minTeam);
        }

    }


}
