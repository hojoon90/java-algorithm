package com.algorithm.datastructure.boj.queue;

import java.io.*;
import java.util.*;

public class BOJ_2164 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= count; i++){
            queue.offer(i);
        }

        while(queue.size() != 1){
            queue.poll();
            queue.add(queue.poll());
        }
        System.out.println(queue.peek());
    }

}
