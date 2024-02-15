package com.algorithm.bfs_dfs.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 리트코드에서 좀 충격먹은 문제
 * 괄호 출력 자체가 어렵게 느껴졌고 어떻게 출력해야할지 감도 잡히지 않아서 바로 풀이부터 봤다.
 * 재귀를 통해서 풀어내는 문제였고 리트코드에 올라온 정답을 보면 노드 리스트를 통해 어떻게 출력할 수 있는지 그려진 그래프가 있었다.
 * 그래프를 찬찬히 보면 어떻게 동작하는지 이해할 수 있는 문제였다.
 *
 * 열린괄호와 닫힌괄호의 카운트를 먼저 세팅해주고 재귀를 통해 열린괄호부터 채워준다.
 * 그리고 나서 열린괄호가 다 채워지면 닫힌 괄호를 채워준다.
 * 이때 괄호를 채워주면서 재귀로 자기자신을 계속 호출한다.
 * 괄호는 2개이므로 주어진 n * 2가 총 괄호의 길이가 된다. 이 길이가 다 채워지면 해당 값을 리스트에 넣어준다.
 * 리스트에 add 하고나면 재귀함수들이 끝나게 되면서 닫힌 괄호를 하나씩 뺀다.
 * 열린괄호가 하나 빠지고 나면 아래 닫는 괄호를 채우는 로직을 타게 되면서 괄호가 하나 닫힌다
 * 그리고 다시 열린 괄호값을 채워주고 나머지 닫힌 괄호값을 채운다.
 *  -> n이 3일 경우
 *      1. 로직대로 돌면서 ((()))가 리스트에 담긴다.
 *      2. 재귀가 끝나고 sb.setLength(sb.length() - 1); 로직으로 '((' 상태가 된다. (열린괄호의 문자까지 하나가 빠진다.)
 *      3. '((' 이 상태에서 아래 닫힌 괄호 로직을 타면서 (() 가 된다.
 *      4. openCnt 조건이 n보다 작으므로 다시 ( 로직을 탄다 '(()('
 *      5. 열린 조건이 만족됐으므로 닫힌 조건을 만족시켜준다 '(()())'
 *      6. 리스트에 넣는다.
 *
 * 이 로직이 계속 반복되면서 모든 괄호를 다 채워주게 된다.
 * 문제 난이도가 한국 알고리즘 문제들과는 뭔가 다른.. 새로운 경험이었다.
 *
 */
//https://leetcode.com/problems/generate-parentheses/description/
public class LC_22 {

    static List<String> answer;
    static StringBuilder sb;

    public static void main(String[] args) {
        int n = 3;
        generateParenthesis(n);
        answer.forEach(i -> System.out.println(i));
    }


    public static List<String> generateParenthesis(int n) {

        sb = new StringBuilder();
        answer = new LinkedList<>();

        dfs(0,0,0,n);

        return answer;
    }

    public static void dfs(int length, int openCnt, int closeCnt, int n){

        if(length == 2*n){
            answer.add(sb.toString());
        }

        if(openCnt < n){
            sb.append("(");
            dfs(length+1, openCnt+1, closeCnt, n);
            sb.setLength(sb.length() - 1);
        }
        if (closeCnt < openCnt) {
            sb.append(")");
            dfs(length+1, openCnt, closeCnt+1, n);
            sb.setLength(sb.length() - 1);
        }

    }
}
