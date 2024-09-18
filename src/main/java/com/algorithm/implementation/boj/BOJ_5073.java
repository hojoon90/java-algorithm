package com.algorithm.implementation.boj;

import java.io.*;
import java.util.*;

public class BOJ_5073 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] triangle = new int[3];
            triangle[0] = Integer.parseInt(st.nextToken());
            triangle[1] = Integer.parseInt(st.nextToken());
            triangle[2] = Integer.parseInt(st.nextToken());

            if(triangle[0] == 0 && triangle[1] == 0 && triangle[2] == 0) break;

            Arrays.sort(triangle);

            if(triangle[2] >= triangle[0] + triangle[1]){
                System.out.println("Invalid");
            }else{
                if(triangle[0] != triangle[1] && triangle[1] != triangle[2] && triangle[2] != triangle[0]){
                    System.out.println("Scalene");
                }else if(triangle[0] == triangle[1] && triangle[1] == triangle[2] && triangle[2] == triangle[0]){
                    System.out.println("Equilateral");
                }else{
                    System.out.println("Isosceles");
                }

            }

        }

    }

}
