package com.algorithm.study.retryqueue.retry00;

import java.io.*;
import java.util.*;

/*
https://www.acmicpc.net/problem/13335
 */
public class BOJ_13335 {

    //실패코드
/*

    static Queue<Integer> q = new LinkedList<>();
    static int[] trucks = new int[11];

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trucks[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        int idx = 0;
        while(idx <= n){
            if(q.size() >= w) {
                q.poll();
            }else{
                q.offer(0);
            }
            int nt = trucks[idx];
            int totalWeight = q.stream().mapToInt(i -> i).sum();
            if(totalWeight + nt <= L){
                q.offer(trucks[idx++]);
            }else{
                q.offer(0);
            }
            result++;
        }
        if(!q.isEmpty()){
            q.poll();
            result++;
        }
        System.out.println(result);
    }
*/

    static Queue<Integer> trucks = new LinkedList<>();
    static int[] bridge = new int[101];
    static int n, w, L;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trucks.offer(Integer.parseInt(st.nextToken()));
        }

        int result = 0;
        //다리 배열을 따로 만들어준다.
        //트럭은 큐에 넣고 하나씩 빼준다.
        // 다리무게는 반복할때마다 계산해준다.
        while(true){
            int bWeight = Arrays.stream(bridge).sum();
            bWeight -= bridge[w-1];
            moveBridge();
            if(!trucks.isEmpty() && (trucks.peek() + bWeight) <= L){
                bridge[0] = trucks.poll();
            }
            result++;
            if(checkBridge()){
                break;
            }

        }
        System.out.println(result);

    }

    static boolean checkBridge(){
        for (int i = 0; i < w; i++) {
            if(bridge[i] != 0)
                return false;
        }
        return true;
    }

    static void moveBridge(){

        for (int i = w-1; i > 0; i--) {
            bridge[i] = bridge[i - 1];
        }
        bridge[0] = 0;

    }
}
