package com.algorithm.dp.boj;

import java.io.*;
import java.util.*;

public class BOJ_10844 {

    static long[][] d = new long[101][10];

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

        // 첫째 자리는 0빼고 다 1자리 이므로 1로 채움.
        for(int i=1;i<10;i++) {
            d[1][i]=1;
        }

        //d[2][j] = d[1][j-1] + d[1][j+1];
        //2번째 자리수 부터 계산
        for(int i=2;i<=n;i++) {
            //0~9까지 탐색 (여기서 0~9는 뒷자리에 들어가는 숫자를 나타낸다.)
            // d[2][0]/d[2][1]/d[2][2]/d[2][3]/d[2][4]/d[2][5]/d[2][6]/d[2][7]/d[2][8]/d[2][9]
            //   10   /   21  / 12,32 / 23,43 / 34,54 / 45,65 / 56,76 / 67,87 / 78,98 / 89
            // 배열 숫자 대로 1,1,2,2,2,2,2,2,2,1 로 세팅된다.
             for(int j=0; j<10; j++) {
                 if(j!=0) d[i][j]+=d[i-1][j-1];
                 if(j!=9) d[i][j]+=d[i-1][j+1];
                 d[i][j] %= 1000000000;
             }
        }

        System.out.println(Arrays.stream(d[n]).sum() % 1000000000);

    }

}
