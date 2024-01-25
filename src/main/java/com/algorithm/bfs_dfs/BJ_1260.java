package com.algorithm.bfs_dfs;

import java.io.*;
import java.util.*;

/**
 * BFS, DFS 첫문제.
 * BFS DFS 를 어떻게 처리하는지 감을 잡기 위해 천천히 작성하였다.
 * 방문한 모든 노드를 출력하는 문제.
 * 노드는 리스트 안의 리스트로 넣어주어 노드별로 어떤 서브 노드들이 있는지 만들어준다(nodeList)
 * 서브노드는 서로 연결되어있으면 각각에 모두 넣어줘야 한다.
 *    ex.1-4가 연결되어있으면 1번노드의 sub엔 4가, 4번노드 sub엔 1이 있어야함.
 * dfs는 스택 방식으로 처리. 다만 스택은 재귀함수와 같은 모습을 하고 있으므로 재귀로 처리해주면 된다.
 * - dfs가 시작되면 먼저 방문한 노드를 체크해주고 노드 번호를 출력한다.
 * - 그리고 nodeList 에서 해당 노드의 서브 노드들을 가져온다.
 * - 서브 노드들의 사이즈 만큼 반복문을 돌려 재귀함수로 호출하여 처리한다.
 * - 이렇게 되면 가장 깊은 노드를 찾아들어가면서 거쳐간 노드를 모두 출력한다.
 * bfs는 큐 방식으로 처리한다. 보통 LinkedList를 생성한 Queue를 사용한다.
 * - bfs를 시작하면 먼저 큐에 시작 노드를 넣어준다.
 * - 그 후 while문을 통해 큐에 데이터가 없을때까지 반복문을 돌린다.
 * - 반복문 안에서 시작 노드의 방문체크를 해준다.
 * - 시작 노드의 번호를 출력한다.
 * - nodeList 에서 해당 노드의 서브 노드들을 가져온다.
 * - 서브 노드들 개수만큼 반복문을 돌면서 방문체크가 안되어있으면 큐에 적재하고 방문처리 해준다.
 *    - 이때 큐에 적재되면 가장 마지막으로 들어간다.
 * - 출력 결과값은 맨 처음 노드의 서브노드 순으로 넓게 노드번호들이 출력된다.
 */
//https://www.acmicpc.net/problem/1260
public class BJ_1260 {
    public static ArrayList<ArrayList<Integer>> nodeList = new ArrayList<>();
    public static boolean[] dfsVisited;
    public static boolean[] bfsVisited;
    public static ArrayList<Integer> dfsList = new ArrayList<>();
    public static ArrayList<Integer> bfsList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" "); //정점 개수 / 간선 개수 / 정점 번호

        int nodeCnt = Integer.parseInt(st[0]) + 1;  //0번째 처리를 위해 +1
        int lineCnt = Integer.parseInt(st[1]);
        int startNode = Integer.parseInt(st[2]);

        dfsVisited = new boolean[nodeCnt];
        bfsVisited = new boolean[nodeCnt];
        for (int i = 0; i < nodeCnt; i++) {
            nodeList.add(new ArrayList<>());// 노드 리스트 초기화
        }

        for (int i = 1; i <= lineCnt; i++) {
            String[] node = br.readLine().split(" ");
            int mNode = Integer.parseInt(node[0]);
            int sNode = Integer.parseInt(node[1]);
            nodeList.get(mNode).add(sNode);
            if(!nodeList.get(sNode).contains(mNode)){
                nodeList.get(sNode).add(mNode);
            }
        }
        nodeList.stream().forEach(i -> i.sort(Comparator.comparingInt(Integer::intValue)));

        dfs(startNode);
        bfs(startNode);

        dfsList.forEach(i -> System.out.print(i + " "));
        System.out.println("");
        bfsList.forEach(i -> System.out.print(i + " "));

    }

    //DFS
    public static void dfs(int startCnt){
        dfsVisited[startCnt] = true;
        dfsList.add(startCnt);
        for (int i = 0; i < nodeList.get(startCnt).size(); i++){
            Integer subNode = nodeList.get(startCnt).get(i);
            if(!dfsVisited[subNode]) dfs(subNode);
        }
    }

    public static void bfs(int startCnt){
        Queue<Integer> q = new LinkedList<>();
        q.offer(startCnt);
        bfsVisited[startCnt] = true;
        while (!q.isEmpty()) {
            int nodeOne = q.poll();
            bfsList.add(nodeOne);
            for (int i = 0; i < nodeList.get(nodeOne).size(); i++) {
                int nodeTwo = nodeList.get(nodeOne).get(i);
                if(!bfsVisited[nodeTwo]){
                    q.offer(nodeTwo);
                    bfsVisited[nodeTwo] = true;
                }
            }
        }
    }

}
