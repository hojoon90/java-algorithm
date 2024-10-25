package com.algorithm.sorting.boj;

import java.io.*;

public class BOJ_2816 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        String[] arr = new String[cnt];

        for( int i = 0; i < cnt; i++){
            arr[i] = br.readLine();
        }

        //KBS1
        find(arr, 0, "KBS1");

        //KBS2
        find(arr, 1, "KBS2");


    }

    static void find(String[] arr, int x, String broadcast) {
        int point = 0;
        while (!arr[x].equals(broadcast)) {

            if (!arr[point].equals(broadcast)) {
                System.out.print(1);
                point++;
            } else {
                System.out.print(4);
                String tmp = arr[point - 1];
                arr[point - 1] = arr[point];
                arr[point] = tmp;
                point--;
            }

        }
    }

}
