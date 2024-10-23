package com.algorithm.binarysearch;

import java.io.*;
import java.util.*;

public class BOJ_10815 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int m = Integer.parseInt(br.readLine());
        int[] mArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] result = new int[m];

        Arrays.sort(nArr);

        for(int i = 0; i < m; i++) {
            result[i] = check(nArr, mArr[i]);
        }

        for (int i : result){
            System.out.print(i+" ");
        }

    }



    public static int check(int[] nArr, int target){
        int st = 0;
        int en = nArr.length-1;
        while(st <= en){
            int mid = (st+en)/2;
            if(nArr[mid] > target){
                en = mid-1;
            }else if(nArr[mid] < target){
                st = mid+1;
            }else{
                return 1;
            }
        }
        return 0;
    }

}
