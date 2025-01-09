package com.algorithm.implementation.boj;

import java.io.*;
import java.util.*;

public class BOJ_1193 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int idx = Integer.parseInt(br.readLine());

        int crossCnt = 1;
        int prevCrossCnt = 0;

        while(true){

            if(idx <= crossCnt+prevCrossCnt){
                String result = "";
                if(crossCnt % 2 == 1){
                    result = crossCnt - (idx - prevCrossCnt - 1) +"/"+ (idx - prevCrossCnt);
                }else{
                    result = (idx - prevCrossCnt) +"/"+ (crossCnt - (idx - prevCrossCnt -1));
                }
                System.out.println(result);
                break;
            }else{
                prevCrossCnt += crossCnt;
                crossCnt++;
            }
        }


    }

}
