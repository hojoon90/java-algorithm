package com.algorithm.implementation.boj;

import java.io.*;

public class BOJ_3758 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test = 0; test < T; test ++){
            int result = 1;
            String[] inputData = br.readLine().split(" ");

            int n = Integer.parseInt(inputData[0]);    //팀 개수
            int k = Integer.parseInt(inputData[1]);    //문제 개수
            int t = Integer.parseInt(inputData[2]);    //팀 ID
            int m = Integer.parseInt(inputData[3]);    //로그 엔트리 개수

            int[][] team = new int[n+1][k+1];
            int[] submitCnt = new int[n+1];
            int[] fasterSubmitTeam = new int[n+1];

            for(int log = 0; log < m; log++){
                String[] inputDataB = br.readLine().split(" ");

                int i = Integer.parseInt(inputDataB[0]);    //팀 ID
                int j = Integer.parseInt(inputDataB[1]);    //문제번호
                int s = Integer.parseInt(inputDataB[2]);    //점수

                fasterSubmitTeam[i] = log+1;
                submitCnt[i]++;

                int eScore = team[i][j];
                team[i][j] = Math.max(s, eScore);
            }

            int[] teamTotalScore = new int[n+1];
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= k; j++){
                    teamTotalScore[i] += team[i][j];
                }
            }

            int myScore = teamTotalScore[t];

            for(int i = 1; i <= n; i++){
                if(i == t) continue;
                int a = teamTotalScore[i];
                if(a == myScore){
                    int subA = submitCnt[i];
                    int subB = submitCnt[t];

                    if(subB == subA){
                        int fasterA = fasterSubmitTeam[i];
                        int fasterB = fasterSubmitTeam[t];

                        if(fasterA < fasterB) result++;
                    }else{
                        if(subB > subA) result++;
                    }
                }else{
                    if(a > myScore) result++;
                }

            }

            System.out.println(result);
        }


    }

}
