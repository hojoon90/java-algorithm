package com.algorithm.greedy.boj;

import java.io.*;
import java.util.*;

public class BOJ_1931_2 {


    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Pair[] conf = new Pair[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sTime = Integer.parseInt(st.nextToken());
            int eTime = Integer.parseInt(st.nextToken());
            Pair pair = new Pair(sTime, eTime);
            conf[i] = pair;
        }

        //엔드타임 기준으로 정렬. 엔드 타임이 같으면 스타트 타임으로 정렬 (o1 - o2 -> 내림차순/ o2 - o1 -> 오름차순)
        Arrays.sort(conf, (o1, o2) -> o1.e == o2.e ?  o1.s - o2.s : o1.e - o2.e);

        int result = 0;
        int endTime = 0;
        for(Pair p: conf){
            if(p.s >= endTime) {
                result ++;
                endTime = p.e;
            }
        }

        System.out.println(result);
    }

    static class Pair{
        int s;
        int e;

        public Pair(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

}
