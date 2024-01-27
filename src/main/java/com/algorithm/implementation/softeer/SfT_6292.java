package com.algorithm.implementation.softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 분할 정복 관련 문제
 * 이것도 공부 후에 다시 봐야 할 것 같다.
 */
//https://softeer.ai/practice/6292
public class SfT_6292 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        long k = Long.parseLong(arr[0]);
        long p = Long.parseLong(arr[1]);
        long n = Long.parseLong(arr[2]);

        n *= 10;

        long result = recursion(p, n);

        System.out.println(k * result % 1000000007);

    }

    static long recursion(long p, long n) {
        if (n == 1)
            return p;

        long cur = recursion(p, n/2);
        if (n % 2 == 1) {
            return (cur * cur % 1000000007) * p % 1000000007;
        }
        else {
            return cur * cur % 1000000007;
        }
    }
}
