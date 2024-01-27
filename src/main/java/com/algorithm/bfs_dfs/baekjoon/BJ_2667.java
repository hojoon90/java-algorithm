package com.algorithm.bfs_dfs.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 배추벌레와 비슷한 문제. 이번엔 dfs를 통해 처리하였다.
 * 로직은 다 만들었지만 마지막에 집 개수를 오름차순으로 정렬하라는 문장을 못봐서 2번정도 틀렸다..
 * chatAt의 경우 int로 변경해주려면 뒤에 -'0'을 붙여주면 된다.
 * 단지 카운트와 집카운트 올리는 위치잡기가 조금 어려웠는데, 처음에는 if문 밖에서 해당 카운트들을 추가하는 로직으로 갔었는데, 잘못 생각했었다.
 * if문 자체가 전체 필드를 검색하다가 조건에 맞는 좌표가 나오면 그 좌표를 기준으로 탐색을 진행하는 것이기 때문에
 * if문 안에서 탐색으로 조회된 값들에 대해 처리를 해주어야 한다.
 * 간단히 말해서 맞는 조건을 찾았을때 모든 카운트들을 처리해준다.
 * 나머지는 비슷했고, 좌표 체크조건은 꼭 넣어주자...
 */
//https://www.acmicpc.net/problem/2667
public class BJ_2667 {

    public static int[][] field;
    public static boolean[][] visited;
    public static int houseCnt = 0;
    public static int size = 0;
    public static ArrayList<Integer> houseCntList = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());

        //필드 초기화 및 세팅
        field = new int[size][size];
        visited = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            String val = br.readLine();
            for (int j = 0; j < val.length(); j++) {
                field[i][j] = val.charAt(j) - '0';
            }
        }

        int danjiCnt = 0;

        for (int i = 0; i < size; i++) { //y
            for (int j = 0; j < size; j++) { //x
                int val = field[i][j];
                if(!visited[i][j] && val == 1 ){
                    houseCnt++;
                    dfs(j,i);
                    danjiCnt++;
                    houseCntList.add(houseCnt);
                    houseCnt = 0;
                }
            }
        }
        System.out.println(danjiCnt);
        houseCntList.stream().sorted().forEach(i -> System.out.println(i));
    }

    //
    public static void dfs(int x, int y) {

        visited[y][x] = true;

        int[] dx = {-1, 1, 0, 0};  //좌우상하
        int[] dy = {0, 0, 1, -1};

        Position p = new Position(x, y);
        for (int i = 0; i < 4; i++) {
            int newX = p.x + dx[i];
            int newY = p.y + dy[i];
            if(isInField(newX, newY)
                    && !visited[newY][newX]
                    && field[newY][newX] == 1){
                houseCnt++;
                dfs(newX, newY);
            }
        }
    }

    private static boolean isInField(int newX, int newY) {
        return newX >= 0 && newX < size && newY >= 0 && newY < size;
    }


    public static class Position{
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
