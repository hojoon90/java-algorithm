package com.algorithm.unclassified;

import java.io.*;
import java.util.*;

public class BOJ_2304 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[1001];
        int cnt = Integer.parseInt(br.readLine());

        int start = Integer.MAX_VALUE;
        int end = 0;

        for(int i = 0; i < cnt; i++){
            String[] s = br.readLine().split(" ");
            int l = Integer.parseInt(s[0]);
            int h = Integer.parseInt(s[1]);
            arr[l] = h;

            start = Math.min(start, l);
            end = Math.max(end, l);

        }

        Stack<Integer> stack = new Stack<>();

        int temp = arr[start];
        for(int i = start + 1; i <= end; i++){
            //기준점 높이가 더 크면
            if(arr[i] < temp){
                stack.push(i);
            //기준점 높이가 더 작거나 같으면
            }else{
                //기준값을 바꾸기 전에 이전 기준값의 높이로 맞춰준다.
                while(!stack.isEmpty()){
                    int x = stack.pop();
                    arr[x] = temp;
                }
                temp = arr[i];
            }
        }
        stack.clear();

        //끝에서부터 비교
        temp = arr[end];
        for(int i = end - 1; i >= start; i--){
            //기준점 높이가 더 크면
            if(arr[i] < temp){
                stack.push(i);
            //기준점 높이가 더 작거나 같으면
            }else{
                while(!stack.isEmpty()){
                    int x = stack.pop();
                    arr[x] = temp;
                }
                temp = arr[i];
            }
        }

        int result = 0;
        for(int i = start; i <= end; i++){
            result += arr[i];
        }
        System.out.println(result);

    }

}
