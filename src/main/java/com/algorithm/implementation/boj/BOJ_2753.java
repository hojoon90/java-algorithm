package com.algorithm.implementation.boj;

import java.util.Scanner;

//https://www.acmicpc.net/problem/2753
public class BOJ_2753 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        int isTrue = 0;

        if (year % 4 == 0) {
            if (year % 100 != 0 || year % 400 == 0) {
                isTrue = 1;
            }
        }
        System.out.println(isTrue);
    }

}
