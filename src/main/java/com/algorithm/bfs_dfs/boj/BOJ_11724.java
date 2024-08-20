package com.algorithm.bfs_dfs.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 연결요소의 개수를 구하는 문제.
 * 연결된 노드들을 하나의 그룹으로 봐주면 된다.
 * 실제 구현도 연결된 노드들을 하나의 그룹으로 보고
 * 탐색작업을 완료한 후 그룹 카운트를 하나씩 올려주었다.
 * 그리고 모든 노드들을 확인해야 하므로 노드 갯수만큼 반복문을 돌려서 모든 노드를 확인해준다.
 * 물론 방문했던 노드이면 무시하고 다음으로 넘어간다.
 */
//https://www.acmicpc.net/problem/11724
public class BOJ_11724 {

    public static ArrayList<ArrayList<Integer>> nodeList = new ArrayList<>();
    public static boolean[] visited;
    public static int nodeGroupCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int nodeCnt = Integer.parseInt(split[0]) + 1;
        int lineCnt = Integer.parseInt(split[1]);

        // 노드 초기화
        for (int i = 0; i < nodeCnt; i++) {
            nodeList.add(new ArrayList<>());
        }
        visited = new boolean[nodeCnt];

        //노드/서브노드 입력
        for (int i = 0; i < lineCnt; i++) {
            String[] nodes = br.readLine().split(" ");
            int mNode = Integer.parseInt(nodes[0]);
            int sNode = Integer.parseInt(nodes[1]);
            nodeList.get(mNode).add(sNode);
            if (!nodeList.get(sNode).contains(mNode)) {
                nodeList.get(sNode).add(mNode);
            }
        }

        for (int i = 0; i < nodeCnt; i++) {
            if(!visited[i]) {
                dfs(i);
                nodeGroupCnt++;
            }
        }

        System.out.println(nodeGroupCnt - 1); //0값은 뺀다.
    }

    public static void dfs(int startNode) {
        visited[startNode] = true;
        ArrayList<Integer> subNodes = nodeList.get(startNode);

        for (int subNode: subNodes) {
            if(!visited[subNode]){
                dfs(subNode);
            }
        }
    }
}
