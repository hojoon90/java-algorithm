package com.algorithm.recursion.boj;

import java.io.*;
import java.util.*;

public class BOJ_17478 {

    public static void main(String[]args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
        func(count, 0, sb);
        System.out.println(sb);
    }

    static void func(int count, int dashCnt, StringBuilder sb){
        String dash = "";
        for (int i = 0; i < dashCnt; i++) {
            dash += "____";
        }
        sb.append(dash+"\"재귀함수가 뭔가요?\"\n");
        if(count == 0){
            sb.append(dash+"\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
        }else{
            sb.append(dash+"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
            sb.append(dash+"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
            sb.append(dash+"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
            func(count-1, dashCnt+1, sb);
        }
        sb.append(dash+"라고 답변하였지.\n");
    }

}
