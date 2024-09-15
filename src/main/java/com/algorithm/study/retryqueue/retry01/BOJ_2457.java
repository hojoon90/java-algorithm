package com.algorithm.study.retryqueue.retry01;

import java.io.*;
import java.util.*;

/*
https://www.acmicpc.net/problem/2457
 */
public class BOJ_2457 {
/*
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Pair[] flowers = new Pair[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sMonth = Integer.parseInt(st.nextToken()) * 100;
            int sDay = Integer.parseInt(st.nextToken());
            int eMonth = Integer.parseInt(st.nextToken()) * 100;
            int eDay = Integer.parseInt(st.nextToken());

            flowers[i] = new Pair(sMonth + sDay, eMonth + eDay);
        }

        Arrays.sort(flowers, (o1, o2) -> o1.start == o2.start ? o1.end - o2.end : o1.start - o2.start);
        int start = 301;
        while(true){
            for (int i = 0; i < n; i++) {

                start = Math.min(flowers[i].start;
            }

        }



    }

    static class Pair{
        int start;
        int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
*/

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Pair[] flowers = new Pair[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sMonth = Integer.parseInt(st.nextToken()) * 100;
            int sDay = Integer.parseInt(st.nextToken());
            int eMonth = Integer.parseInt(st.nextToken()) * 100;
            int eDay = Integer.parseInt(st.nextToken());

            flowers[i] = new Pair(sMonth + sDay, eMonth + eDay);
        }

        int result = 0;
        int sTime = 301;
        while(sTime < 1201){
            int nextTime = sTime;
            for (int i = 0; i < n; i++) {
                Pair p = flowers[i];
                //다음 꽃피는 시간이 꽃이 지는 시간보다 작으면. 즉 꽃이 지는 시간이 더 기니까 그 시간만큼 꽃을 피울 수 있다.
                if( p.start <= sTime && p.end > nextTime ){
                    nextTime = p.end;
                }
            }
            if(nextTime == sTime){
                System.out.println(0);
                return;
            }
            result++;
            sTime = nextTime;
        }
        System.out.println(result);

    }

    static class Pair{
        int start;
        int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
