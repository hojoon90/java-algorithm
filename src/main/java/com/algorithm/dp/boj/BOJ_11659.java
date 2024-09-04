package com.algorithm.dp.boj;

import java.io.*;
import java.util.*;

public class BOJ_11659 {

    static int[] d = new int[100005];
    static int[] a = new int[100005];

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            //d[i] = a[1]+a[2]+...+a[i] -> d[i-1] + a[i]
            d[i] = d[i-1] + a[i];
        }

        //a[i] 부터 a[j] 까지의 합은 a[1]부터 a[j]까지 더한 합에서 a[1]부터 a[i-1]까지의 합을 뺀 값이다.
        // a[i]+a[i+1]...+a[j] = (a[1]+a[2]+...+a[j])-(a[1]+a[2]+...+a[i-1])
        // = d[j] - d[i-1] (a[i]부터 a[j]까지 다 더한 합)
        for (int cnt = 0; cnt < m; cnt++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            System.out.println(d[j] - d[i-1]);

        }

    }
}
