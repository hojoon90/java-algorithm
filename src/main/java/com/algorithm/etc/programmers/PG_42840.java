package com.algorithm.etc.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PG_42840 {



    public static void main(String[] args) {
        int[] answers = {1, 2, 3, 4, 5};
        System.out.println(solution(answers));

    }

    public static int[] solution(int[] answers) {

        int[] A = {1, 2, 3, 4, 5};
        int[] B = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] C = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] point = new int[3];

        for (int i = 0; i < answers.length; i++) {
            if(answers[i] == A[i % A.length]) point[0]++;
            if(answers[i] == B[i % B.length]) point[1]++;
            if(answers[i] == C[i % C.length]) point[2]++;
        }

        List<Integer> people = new ArrayList<>();
        int max = Math.max(point[0], Math.max(point[1], point[2]));
        for (int i = 0; i < 3; i++) {
            if(point[i] == max) people.add(i+1);
        }


        int[] answer = new int[people.size()];
        for(int i=0; i<people.size(); i++){
            answer[i] = people.get(i);
        }

        return answer;
    }
}
