package com.algorithm.dp.boj;

import java.io.*;
import java.util.*;

public class BOJ_1912 {

    static int[] d = new int[100005];

    public static void main(String[] args) throws IOException{

        //a[i] > a[i] + a[i+1] ? a[i] = a[i] + a[i+1] : a[i]; index++
        //맨 앞 값보다 두개 더한게 더 크면 계속 더해진다.
        //크지 않으면 그냥 두고 다음수를 연속으로 더한다.
        //앞에서 부터 계속 더하는데 더한 값이 음수면 패스?

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        d[1] = arr[0];
        int result = arr[0];
        for (int i = 2; i <= n; i++) {
            if(d[i-1] + arr[i-1] >= arr[i-1]){
                d[i] = d[i-1] + arr[i-1];
            }else{
                d[i] = arr[i-1];
            }
            result = Math.max(result, d[i]);
        }

        System.out.println(result);
    }

}
