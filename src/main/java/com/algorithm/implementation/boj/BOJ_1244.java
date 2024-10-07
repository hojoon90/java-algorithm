package com.algorithm.implementation.boj;

import java.io.*;

public class BOJ_1244 {

    static int[] arr = new int[105];

    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] switchArr = br.readLine().split(" ");
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(switchArr[i-1]);
        }

        int hCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < hCnt; i++) {
            String[] sArr = br.readLine().split(" ");
            int gender = Integer.parseInt(sArr[0]);
            int switchNum = Integer.parseInt(sArr[1]);

            if(gender == 1){
                for (int j = switchNum; j < n; j += switchNum) {
                    arr[j] = switchOnOff(j);
                }
            }

            if(gender == 2){
                int left = switchNum - 1;
                int right = switchNum + 1;
                while (left > 0 && right <= n) {
                    if (arr[left] != arr[right]) {
                        break;
                    }
                    left--;
                    right++;
                }

                for (int j = left + 1; j < right; j++) {
                    arr[j] = switchOnOff(j);
                }
            }

        }

        for (int i = 1; i <= n; i++) {
            sb.append(arr[i]).append(" ");
            if(i % 20 == 0) sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int switchOnOff(int switchNum) {
        return arr[switchNum] == 0 ? 1 : 0;
    }

}


