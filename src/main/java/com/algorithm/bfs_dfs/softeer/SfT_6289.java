package com.algorithm.bfs_dfs.softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SfT_6289 {
    public static ArrayList<ArrayList<Integer>> relationship = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int peopleCnt = Integer.parseInt(tk.nextToken());
        int relation = Integer.parseInt(tk.nextToken());

        int [] weight = new int[peopleCnt+1];
        tk = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= peopleCnt; i++) weight[i] = Integer.parseInt(tk.nextToken());

        for (int i = 0; i <= peopleCnt; i++) {
            relationship.add(new ArrayList<>());
        }

        for (int i = 0; i < relation; i++) {
            tk = new StringTokenizer(br.readLine(), " ");
            int p1 = Integer.parseInt(tk.nextToken());
            int p2 = Integer.parseInt(tk.nextToken());
            relationship.get(p1).add(p2);
            relationship.get(p2).add(p1);
        }

        int result = 0;
        for (int i = 1; i <= peopleCnt; i++) {
            boolean isHeavier = true;
            ArrayList<Integer> integers = relationship.get(i);
            for (int j = 0; j < integers.size(); j++) {
                int friend = integers.get(j);
                if (weight[i] <= weight[friend]) {
                    isHeavier = false;
                    break;
                }
            }
            if (isHeavier) result++;
        }
        System.out.println(result);


    }

}
