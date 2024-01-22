package com.algorithm;

import java.util.Scanner;

/**
 * 5로 나누었을 때 몫을 잘 생각해야 한다.
 * 10~15 사이를 기준으로 보았을 때
 * 10: 5kg 2개           = 2
 * 11: 5Kg 1개, 3kg 2개   = 3
 * 12: 5Kg 0개, 3kg 4개   = 4
 * 13: 5Kg 2개, 3kg 1개   = 3
 * 14: 5Kg 1개, 3kg 3개   = 4
 *
 * 15 ~ 20
 * 15: 5kg 3개           = 3
 * 16: 5Kg 2개, 3kg 2개   = 4
 * 17: 5Kg 1개, 3kg 4개   = 5
 * 18: 5Kg 3개, 3kg 1개   = 4
 * 19: 5Kg 2개, 3kg 3개   = 5
 *
 * 5와 3 두개의 수로 나뉘지 않는 4, 7을 제외한 나머지는 모두 알맞은 무게로 분배가 가능하다.
 * 몫 기준으로 나머지 1,3은 +1 나머지 2,4 는 +2를 해준다. 그렇기에 그 조건에 맞게 값을 리턴해준다.
 */
//https://www.acmicpc.net/problem/2839
public class BJ_2839 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int kg = sc.nextInt();
        int count = 0;

        if (kg == 4 || kg == 7) {
            count = -1;
        } else if (kg % 5 == 0) {
            count = kg / 5;
        } else if (kg % 5 == 1 || kg % 5 == 3) {
            count = kg / 5 + 1;
        } else if (kg % 5 == 2 || kg % 5 == 4) {
            count = kg / 5 + 2;
        }

        System.out.println(count);

    }

}
