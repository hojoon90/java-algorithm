package com.algorithm.datastructure.baekjoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1966 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int cnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < cnt; i++) {
            int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int length = s[0];
            int idx = s[1];

            LinkedList<int[]> q = new LinkedList<>();

            String[] s1 = br.readLine().split(" ");
            for (int j = 0; j < length; j++) {
                q.offer(new int[]{j, Integer.parseInt(s1[j])});
            }

            int count = 0;

            while (!q.isEmpty()) {

                int[] front = q.poll();
                boolean isMax = true;


                for (int j = 0; j < q.size(); j++) {

                    if(front[1] < q.get(j)[1]){
                        q.offer(front);
                        for (int k = 0; k < j; k++) {
                            q.offer(q.poll());
                        }

                        isMax = false;
                        break;
                    }
                }
                if(isMax == false){
                    continue;
                }

                count++;
                if (front[0] == idx) {
                    break;
                }


            }
            sb.append(count).append('\n');

        }
        System.out.println(sb);

    }
}
