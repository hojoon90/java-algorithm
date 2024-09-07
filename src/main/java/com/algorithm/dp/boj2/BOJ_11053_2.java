package com.algorithm.dp.boj2;

import java.io.*;
import java.util.*;

public class BOJ_11053_2 {

    static int[] d = new int[1005];

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 1; i <= n; i++) {
            d[i] = 1;
        }

        int mx = 1;
        //for문으로 하나 증가할떄마다 앞에 수들을 모두 체크하면서 최대값을 찾아낸다.
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if(a[i-1] > a[j-1]) d[i] = Math.max(d[i], d[j]+1);  //d[i]에 세팅 된 값이 d[j]+1(d[j] 에서 늘어난 자리수 추가를 위헤 +1 해줌)보다 큰지 확인
            }
            mx = Math.max(mx, d[i]);
        }

        System.out.println(mx);

    }
}

