package com.algorithm.unclassified;

import java.io.*;
import java.util.Arrays;

public class BOJ_19637 {
    static String[] callArr;
    static int[] numArr;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        callArr = new String[n];
        numArr = new int[n];

        for(int i = 0; i < n; i++){
            String[] arr = br.readLine().split(" ");
            callArr[i] = arr[0];
            numArr[i] = Integer.parseInt(arr[1]);
        }


        for (int i = 0; i < m; i++) {
            int power = Integer.parseInt(br.readLine());
            int idx = binarySearch(numArr, power); // 이분 탐색으로 위치 찾기
            sb.append(callArr[idx]).append("\n"); // StringBuilder 사용으로 성능 개선
        }

        System.out.println(sb);
    }

    public static int binarySearch(int[] arr, int power){
        int left = 0;
        int right = arr.length - 1;
        while(left < right){
            int mid = (left + right) / 2;
            if(arr[mid] >= power){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

}
