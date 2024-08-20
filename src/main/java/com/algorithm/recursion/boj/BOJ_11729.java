package com.algorithm.recursion.boj;

import java.io.*;
import java.util.*;

public class BOJ_11729 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append((1<<count) - 1 +"\n");
        moveDisc(1, 3, count, sb);

        System.out.println(sb);
    }

    static void moveDisc(int start, int end, int count, StringBuilder sb){
        if(count == 1) {
            sb.append(start+" "+end+"\n");
            return;
        }
        moveDisc(start, 6-start-end, count-1, sb);
        sb.append(start+" "+end+"\n");
        moveDisc(6-start-end, end, count -1, sb);
    }

}
