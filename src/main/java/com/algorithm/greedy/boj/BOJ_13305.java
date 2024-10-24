package com.algorithm.greedy.boj;

import java.io.*;
import java.util.*;

/*
    기름이 쌀 경우 많이 넣어준다.
    -> 최저 기름값을 찾기 전까지는 최소 이동거리만큼의 기름만 넣어준다.
    -> 최저 기름을 찾으면 더 낮은 기름값을 찾기전까지 그 기름값으로 거리 계산을 더해준다.
 */
public class BOJ_13305 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Integer.parseInt(br.readLine());
        long[] dArr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long[] oilPArr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        long cheepPrice = Long.MAX_VALUE;
        long totalPrice = 0;
        for(int i = 0; i < n-1; i++){
            long price = oilPArr[i];
            cheepPrice = Math.min(cheepPrice, price);
            totalPrice += cheepPrice * dArr[i];
        }

        System.out.println(totalPrice);

    }

}
