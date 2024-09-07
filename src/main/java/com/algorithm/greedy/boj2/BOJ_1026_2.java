package com.algorithm.greedy.boj2;

import java.io.*;
import java.util.*;

public class BOJ_1026_2 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Integer[] b = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);

        Arrays.sort(a);
        Arrays.sort(b, Comparator.reverseOrder());

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += a[i] * b[i];
        }
        System.out.println(result);
    }

}
