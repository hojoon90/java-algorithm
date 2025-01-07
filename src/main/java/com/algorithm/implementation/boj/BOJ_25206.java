package com.algorithm.implementation.boj;

import java.io.*;
import java.util.*;

public class BOJ_25206 {

    public static String[] gradeArr = {"A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F"};
    public static double[] gradeScoreArr = {4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.0};

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double totalGrade = 0;
        double totalScore = 0;

        for(int i = 0; i < 20; i++){
            String s = br.readLine();
            String[] strArr = s.split(" ");
            String grade = strArr[2];
            double gradeScore = Double.parseDouble(strArr[1]);

            if(grade.equals("P")){
                continue;
            }

            for(int j = 0; j < gradeArr.length; j++){
                if(gradeArr[j].equals(grade)){
                    totalScore += gradeScoreArr[j] * gradeScore;
                    break;
                }
            }

            if (!grade.equals("F")) {
                totalGrade += gradeScore;
            }        }

        if (totalGrade == 0) {
            System.out.println(0.0);
        } else {
            System.out.println(totalScore / totalGrade);
        }
    }

}
