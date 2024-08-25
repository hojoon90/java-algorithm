package com.algorithm.datastructure.boj.dequeue;

import java.io.*;
import java.util.*;

public class BOJ_5430 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        for(int test = 0; test < count; test++){
            boolean isReverse = false;
            boolean isError = false;
            Deque<Integer> dq = new LinkedList<>();

            char[] command = br.readLine().toCharArray();
            int length = Integer.parseInt(br.readLine());
            String[] s = br.readLine().replace("[", "").replace("]", "").split(",");

            for (int i = 0; i < length; i++) {
                dq.offer(Integer.parseInt(s[i]));
            }

            for (int i = 0; i < command.length; i++) {
                if(command[i] == 'R') {
                    isReverse = !isReverse;
                }else{
                    if(dq.isEmpty()) {
                        System.out.println("error");
                        isError = true;
                        break;
                    }
                    if(isReverse) dq.pollLast();
                    else dq.pollFirst();
                }
            }
            if(!isError){
                List<Integer> result = new ArrayList<>();
                int size = dq.size();
                for (int i = 0; i < size; i++) {
                    if(isReverse) {
                        result.add(dq.pollLast());
                    } else {
                        result.add(dq.pollFirst());
                    }
                }
                System.out.println(result.toString().replace(", ",","));
            }


        }


    }
}
