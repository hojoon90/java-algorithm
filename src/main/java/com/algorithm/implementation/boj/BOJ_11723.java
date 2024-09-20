package com.algorithm.implementation.boj;

import java.io.*;
import java.util.*;

public class BOJ_11723 {

    public static void main(String[] args) throws IOException{

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[21];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int num = 0;
            if(st.hasMoreTokens()){
                num = Integer.parseInt(st.nextToken());
            }

            switch(cmd){
                case "add":{
                    if(a[num] != 1){
                        a[num] = 1;
                    }
                    break;
                }
                case "remove":{
                    if(a[num] != 0){
                        a[num] = 0;
                    }
                    break;
                }
                case "check":{
                    sb.append(a[num]).append("\n");
                    break;
                }
                case "toggle":{
                    if(a[num] == 0) a[num] = 1;
                    else a[num] = 0;
                    break;
                }
                case "all":{
                    for (int j = 1; j <= 20; j++) {
                        a[j] = 1;
                    }
                    break;
                }
                case "empty":{
                    a = new int[21];
                    break;
                }
                default:{}
            }
        }


            System.out.println(sb);
    }

}
