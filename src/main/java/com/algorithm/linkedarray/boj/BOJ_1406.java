package com.algorithm.linkedarray.boj;

import java.io.*;
import java.util.*;

public class BOJ_1406 {

    public static void main (String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> text = Arrays.asList(br.readLine().split(""));
        LinkedList<String> textList = new LinkedList<>(text);
        int cmdCnt = Integer.parseInt(br.readLine());

        ListIterator<String> iter = textList.listIterator();

        /*
            L: 왼쪽 이동
            D: 오른쪽 이동
            B: 왼쪽 삭제
            P $: $ 입력
         */
        while(iter.hasNext()) {
            iter.next();
        }

        for(int i = 0; i < cmdCnt; i++){
            String cmd = br.readLine();
            if (cmd.contains("L") && iter.hasPrevious()) {iter.previous();}

            if(cmd.contains("D") && iter.hasNext()) {iter.next();}

            if(cmd.contains("B") && iter.hasPrevious()){
                iter.previous();
                iter.remove();
            }

            if(cmd.contains("P")){
                String str = cmd.split(" ")[1];
                iter.add(str);
            }
        }

        for (String str : textList){
            System.out.print(str);
        }

    }
}
