package com.algorithm.sorting.boj;

import java.io.*;
import java.util.*;

public class BOJ_1431 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        String[] serialArr = new String[count];

        for (int i = 0; i < count; i++) {
            serialArr[i] = br.readLine();
        }
        Arrays.sort(serialArr);
        Arrays.sort(serialArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() < o2.length()) {
                    return -1;
                }
                else if(o1.length() == o2.length()){
                    int o1Sum = 0;
                    int o2Sum = 0;

                    for (int i = 0; i < o1.length(); i++) {
                        if(!Character.isAlphabetic(o1.charAt(i))){
                            o1Sum += o1.charAt(i) - '0';
                        }

                        if(!Character.isAlphabetic(o2.charAt(i))){
                            o2Sum += o2.charAt(i) - '0';
                        }
                    }

                    if(o1Sum < o2Sum) {
                        return -1;
                    }else if(o1Sum > o2Sum){
                        return 1;
                    }else{
                        return 0;
                    }
                }else{
                    return 1;
                }
            }
        });

        for(String a: serialArr){
            System.out.println(a);
        }

    }

}
