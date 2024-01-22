package com.algorithm;

import java.util.*;

//문자열 재정렬
public class Char_sort {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        List<Character> charList = new ArrayList<>();
        int num = 0;

        for (int i = 0; i < next.length(); i++) {
            char c = next.charAt(i);
            if(Character.isLetter(c)) charList.add(c);
            else num += c - '0';
        }

        Collections.sort(charList);

        charList.forEach(i -> System.out.print(i));
        if(num != 0) System.out.print(num);
    }

}
