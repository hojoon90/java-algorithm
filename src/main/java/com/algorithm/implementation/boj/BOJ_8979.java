package com.algorithm.implementation.boj;

import java.io.*;
import java.util.*;

public class BOJ_8979 {

    static Nation[] nations = new Nation[1005];

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken()) * 4;
            int silver = Integer.parseInt(st.nextToken()) * 2;
            int bronze = Integer.parseInt(st.nextToken()) * 1;
            nations[idx] = new Nation(gold, silver, bronze);
        }

        Nation sn = nations[k];
        int rank = 1;
        for (int i = 1; i <= n; i++) {
            if( i == k ) continue;
            Nation an = nations[i];

            if(an.gold > sn.gold){
                rank++;
            }else if (an.gold == sn.gold){
                if(an.silver > sn.silver){
                    rank++;
                }else if(an.silver == sn.silver){
                    if(an.bronze > sn.bronze){
                        rank++;
                    }
                }
            }

        }

        System.out.println(rank);
    }

    static class Nation{
        int gold;
        int silver;
        int bronze;

        public Nation(int gold, int silver, int bronze) {
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
    }

}
