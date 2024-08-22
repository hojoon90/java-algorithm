package com.algorithm.backtracking.boj;

import java.io.*;
import java.util.*;

public class BOJ_15649 {

    static int[] resultArr = new int[10];
    static boolean[] isUsed = new boolean[10];
    static int n;
    static int m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        func(0);
        System.out.println(sb);
    }

    static void func(int k){
        if(k == m){ //K는 0 인덱스에서 시작. k == m 은 즉 result 배열에 m개만큼 쌓였다는 이야기 (k-1의 인덱스가 m번째 이므로)
            for(int i = 0; i < m; i++){
                int result = resultArr[i];
                sb.append(result + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= n; i++){
            if(!isUsed[i]){         //함수 인자가 아직 사용되지 않은 값이면
                resultArr[k] = i;   //k번째에 값을 넣어준다.
                isUsed[i] = true;   //해당 숫자를 사용으로 만들어주고
                func(k+1);       //그리고 그 다음 인덱스를 타게 한다.
                isUsed[i] = false;  //더이상 확인할 게 없으므로 false로 돌려준다.
            }
        }

    }

}
