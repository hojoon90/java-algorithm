package com.algorithm.implementation.boj;

import java.io.*;
import java.util.*;

public class BOJ_7568 {

    static Pair[] p = new Pair[55];
    static int[] rank = new int[55];

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            p[i] = new Pair(w, h);
        }

        for (int i = 0; i < n; i++) {
            Pair p1 = p[i];
            int r = 1;
            for (int j = 0; j < n; j++) {
                if(i == j) continue;
                Pair p2 = p[j];
                if(p2.x > p1.x && p2.y > p1.y){
                    r++;
                }
            }
            rank[i] = r;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(rank[i]+" ");
        }

    }


    static class Pair{
        int x;
        int y;

        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
