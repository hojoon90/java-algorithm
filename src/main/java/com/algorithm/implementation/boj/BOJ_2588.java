package com.algorithm.implementation.boj;

import java.util.Scanner;

//https://www.acmicpc.net/problem/2588
public class BOJ_2588 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        String b = sc.next();
        String[] bArr = b.split("");
        Integer bInt = Integer.parseInt(b);

        for (int i = bArr.length - 1; i >= 0; i--) {
            int newB = Integer.parseInt(bArr[i]);
            System.out.println(a*newB);
        }

        System.out.println(a*bInt);

    }

}
