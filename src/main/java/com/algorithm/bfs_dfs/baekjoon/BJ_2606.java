package com.algorithm.bfs_dfs.baekjoon;


import java.io.*;
import java.util.*;

/**
 * BFS 처리 문제
 * 전형적인 BFS 문제인 것 같다.
 * 노드 초기화와 큐 구현 부분에서 살짝 버벅이긴 했지만 별도 참고없이 혼자 푼 문제.
 * 먼저 노드와 방문체크를 초기화해주고 각 노드들을 세팅해준다.
 * 문제에서 원하는건 "1번 컴퓨터를 통해 감염되는 컴퓨터의 수" 이므로 1번을 제외한 나머지 감염컴퓨터의 수를 제공해주면 된다.
 * 큐에 1번 컴퓨터를 넣어주고 bfs 처리를 진행해준다.
 * 방문한 노드 카운트를 별도 변수(virusCnt)에 저장해서 올려주고 bfs 탐색이 끝나면 카운트 수를 출력한다.
 */
//https://www.acmicpc.net/problem/2606
public class BJ_2606 {

    public static ArrayList<ArrayList<Integer>> nodeList = new ArrayList<>();
    public static boolean[] bfsVisited;
    public static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int computerCnt = Integer.parseInt(br.readLine())+1;
        int nodeLine = Integer.parseInt(br.readLine());

        //노드, 방문체크 초기화
        bfsVisited = new boolean[computerCnt];
        for (int i = 0; i < computerCnt; i++) {
            nodeList.add(new ArrayList<>());
        }

        for (int i = 0; i < nodeLine; i++) {
            String[] split = br.readLine().split(" ");
            int mNode = Integer.parseInt(split[0]);
            int sNode = Integer.parseInt(split[1]);
            nodeList.get(mNode).add(sNode);
            if(!nodeList.get(sNode).contains(mNode)){
                nodeList.get(sNode).add(mNode);
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        q.offer(1);
        int virusCount = 0;
        while (!q.isEmpty()){
            int node = q.poll();
            bfsVisited[node] = true;

            ArrayList<Integer> subNodeList = nodeList.get(node);
            for (int nodeNum : subNodeList) {
                if(!bfsVisited[nodeNum]){
                    bfsVisited[nodeNum] = true;
                    q.offer(nodeNum);
                    virusCount++;
                }
            }
        }
        return virusCount;
    }

}
