package com.algorithm.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(arr);
        int before = arr[0];
        int result = 1;

        for (int i = 1; i < count; i++) {
            if(before != arr[i]){
                result++;
            }
            before = arr[i];
        }

        if(result >= 3) {
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

    }
}
