package com.algorithm.sorting.boj;

import java.io.*;
import java.util.*;

public class BOJ_10814 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Person> list = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            String[] s = br.readLine().split(" ");
            Person p = new Person(Integer.parseInt(s[0]), s[1]);
            list.add(p);
        }

        Collections.sort(list, Comparator.comparing(i -> i.age));

        for(Person p : list){
            System.out.println(p.toString());
        }
    }

    static class Person{
        int age;
        String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return  age +" "+ name;
        }
    }

}
