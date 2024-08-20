package com.algorithm.array.boj;

import java.io.*;
import java.util.*;

public class BOJ_3273 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arrCnt = Integer.parseInt(br.readLine());
        int[] countArr = new int[1000001];
        int[] numArr = new int[arrCnt];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < arrCnt; i++){
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        int sumNo = Integer.parseInt(br.readLine());

        int result = 0;

        for(int i = 0; i < arrCnt; i++){
            int countAIdx = numArr[i];
            int countBIdx = sumNo - countAIdx;

            if(countBIdx < 0 ) continue;

            if(countArr[countBIdx] == 0){
                countArr[countAIdx] += 1;
            }else{
                result += 1;
            }
        }

        System.out.println(result);

    }
}
