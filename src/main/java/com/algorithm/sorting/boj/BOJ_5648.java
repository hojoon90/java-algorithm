package com.algorithm.sorting.boj;

import java.io.*;
import java.util.*;

public class BOJ_5648 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        long[] numArr = new long[n];

        while(n > 0){
            while(st.hasMoreTokens()) {
                String numStr = st.nextToken();
                String tmp = "";
                for (int j = numStr.length() - 1; j >= 0; j--) {
                    tmp += numStr.charAt(j);
                }
                numArr[n--] = Long.parseLong(tmp);
            }
            if(n > 0){
                st = new StringTokenizer(br.readLine());
            }
        }

        Arrays.sort(numArr);
        for(long i:numArr){
            System.out.println(i);
        }
    }

//    public static void main(String[] args) throws IOException{
//
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        long[] numArr = new long[n];
//
//        for (int i = 0; i < n; i++) {
//            String numStr = sc.next();
//            String tmp = "";
//            for (int j = numStr.length()-1; j >=0 ; j--) {
//                tmp += numStr.charAt(j);
//            }
//            numArr[i] = Long.parseLong(tmp);
//        }
//
//        Arrays.sort(numArr);
//        for(long i:numArr){
//            System.out.println(i);
//        }
//    }

}
