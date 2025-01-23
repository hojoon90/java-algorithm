package com.algorithm.bruteforce;

import java.io.*;
import java.util.*;

public class BOJ_1075 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String nStr = br.readLine();
        long f = Long.parseLong(br.readLine());

        nStr = nStr.substring(0, nStr.length()-2) + "00";
        long n = Long.parseLong(nStr);

        while (n % f != 0) {
            n++;
        }

        String result = String.valueOf(n);
        result = result.substring(result.length()-2);

        System.out.println(result);
    }

}
