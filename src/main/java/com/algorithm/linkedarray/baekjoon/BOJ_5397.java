package com.algorithm.linkedarray.baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_5397 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        for(int i = 0; i < count; i++){
            char[] password = br.readLine().toCharArray();
            LinkedList<Character> answer = new LinkedList<>();
            ListIterator<Character> iter = answer.listIterator();

            for(char str: password){
                switch(str){
                    case '<':
                        if(iter.hasPrevious()){
                            iter.previous();
                        }
                        break;
                    case '>':
                        if(iter.hasNext()){
                            iter.next();
                        }
                        break;
                    case '-':
                        if(iter.hasPrevious()){
                            iter.previous();
                            iter.remove();
                        }
                        break;
                    default:
                        iter.add(str);
                        break;
                }

            }

            StringBuilder sb = new StringBuilder();
            for(char s:answer){
                sb.append(s);
            }
            System.out.println(sb.toString());
        }


    }

}
