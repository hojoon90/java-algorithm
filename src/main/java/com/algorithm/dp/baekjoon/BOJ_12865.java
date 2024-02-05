package com.algorithm.dp.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 배낭 문제. 꽤나 유명한 문제인걸 문제 풀고 나서 알았다.
 * 처음에는 이 문제를 어떻게 접근해야할지 고민하는 시간이 좀 됐었다.
 * DP 혹은 완전탐색으로 풀 수 있을것 같았는데 그 이유는 다음과 같았다.
 * DP: 들 수 있는 무게에서 가장 가치가 높은 물건들을 선택해야해서 생각. 즉, 서로 비교하면서 가장 가치가 높은 물건들을 선택해야함.
 * 완전탐색: 결국 물건들을 모두 하나씩 대입하며 완전 탐색으로 필요한 물건들을 찾아 나가야 한다 생각.
 *
 * 결론은 DP 로 풀수 있는 문제였다. 나는 완전탐색으로 접근했는데, 문제를 풀다가 시간도 다 보내 버렸고 무엇보다 완전탐색으로는 풀리지 않았다.
 * 이 문제의 핵심은 내가 들 수 있는 무게 중 가장 가치값을 높게 가져갈 수 있는 물건들을 선택하는 것이다.
 * DP 를 이용 해 아이템 하나 당 가장 높은 무게만큼 가치값을 세팅해준다. (dp[아이템수][무게값])
 * 그리고 무게와 가치 값도 배열에 하나씩 세팅해준다.
 * 아이템 하나 당 무게가 올라갈 때 마다 전에 세팅한 가치값을 가져온다.
 * 왜냐하면 무게가 늘어나면 이전 무게의 가치값 + a가 될 수 있기 때문이다.
 * 그리고 현재 세팅된 무게에서 아이템의 무게를 뺐을 때, 무게가 남으면 추가적인 아이템을 찾도록 한다.
 *
 * 추가적인 아이템을 찾는 식이 많이 헷갈리는 문제인데... 만약 현재 선택된 무게에서 선택한 아이템의 무게만큼을 뺐을 때 남은 무게를 가리키는 숫자의 배열..?
 * 다시 말하면 현재 무게에서 선택된 무게를 뺐을때 나오는 숫자를 이전 아이템에서 세팅한 가치값을 가져오는 용도로 사용한다.
 * 즉, 무게 7에서 현재 아이템 무게 3을 빼면 4가 나오고, 이 4는 이전 아이템의 가치값을 찾는데 사용하는 것이다.
 * 이렇게 해서 가장 마지막 수를 구하면 가져갈수 있는 값의 최대치 값을 가져오게 된다.
 *
 * 생각보다 이해가 잘 안돼서 몇번이고 계속 다시 보고 있는 문제;...
 */
//https://www.acmicpc.net/problem/12865
public class BOJ_12865 {

    public static int[] value;
    public static int[] weight;
    public static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(tk.nextToken());
        int K = Integer.parseInt(tk.nextToken());

        dp = new int[N + 1][K + 1];
        weight = new int[N+1];
        value = new int[N+1];

        for (int i = 1; i <= N; i++) {
            tk = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(tk.nextToken());
            value[i] =  Integer.parseInt(tk.nextToken());
        }

        for (int i = 1; i <= N; i++) {  // i = 아이템
            for (int j = 1; j <= K; j++) { // j = 무게
                dp[i][j] = dp[i-1][j];    // 이전 값의 가치를 똑같이 저장함.
                if(j - weight[i] >= 0) { // 만약 현재 무게에서 아이템 무게를 뺐을 때 값이 남으면,
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]); // 저장 후 선택된 무게에서 아이템의 무게만큼 뺐을때 값이 남으면 더 더할게 있는지 찾음
                    //dp[i - 1][j - weight[i]] -> 이전 아이템 중 현재 아이템의 무게를 빼고 남은 무게가 있는 배열..?
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
