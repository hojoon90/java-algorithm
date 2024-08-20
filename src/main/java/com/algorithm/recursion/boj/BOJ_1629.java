package com.algorithm.recursion.boj;

import java.io.*;
import java.util.*;

public class BOJ_1629 {

    public static void main(String[]args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(func(a,b,c));


    }

    static int func(int a, int b, int c){
        if(b == 1) return a % c;
        int value = func(a, b/2, c);    //원래 제곱의 반인 값을 리턴한다.
        value = value * value % c;         //실제 계산해야 하는 값은 a^n * a^n % c -> (a^2n % c)
        if(b % 2 == 0) return value;       //2로 나눠지면 value 리턴
        return value * a % c;              //2로 안나눠지면 a를 한번 곱해서 처리. (a를 한번 더 곱하니까 거기에서 나머지 값 가져오기..?)
    }

}
