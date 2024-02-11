package com.algorithm.implementation.softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 오름차순 내림차순에 대한 비교 문제...?
 * 구현 자체는 단순하게 생각해서 했지만 코드가 좀 중복되었다.
 * 다른 풀이를 보면 아예 오름차순과 내림차순을 정의해놓고 배열 비교만으로 결과값을 출력한다.
 * 코드를 줄일수 있으면... 더 줄여봐야할 것 같다.
 */
public class SfT_6283 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        String result = "mixed";
        int startNo = Integer.parseInt(s[0]);

        if (startNo == 1){
            result = "ascending";
            for (int i = 0; i < s.length; i++) {
                int gear = Integer.parseInt(s[i]);
                if(gear != startNo){
                    result = "mixed";
                    break;
                }
                startNo++;
            }
        }
        if (startNo == 8){
            result = "descending";
            for (int i = 0; i < s.length; i++) {
                int gear = Integer.parseInt(s[i]);
                if(gear != startNo){
                    result = "mixed";
                    break;
                }
                startNo--;
            }
        }

        System.out.println(result);
    }
}
