package com.algorithm.simulation;

import java.io.*;
import java.util.*;

public class BOJ_13335 {

    //실패코드
/*
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int result = 0;

        int[] trucks = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int truckIdx = 0;

        //더이상 트럭이 없을땐 q에서 빼기만 처리
        if(n - 1 == truckIdx){
            q.poll();
            result++;
            continue;
        }

        int truck = trucks[truckIdx];
        if(q.peek() + truck <= L){
            q.offer(truck);
            truckIdx++;
        }else{
            q.offer(0);
        }

        result++;

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

        int result = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            trucks.offer(Integer.parseInt(st.nextToken()));
        }

        while(true){
            int weight = calculate();   //전체 다리무게 계산
            weight-=bridge[w-1];    //맨 뒤의 다리 값 빼기(땡기기 위해)
            moveTruck();            //트럭들을 하나씩 앞으로 옮김
            if(!trucks.isEmpty() && (weight + trucks.peek() <= L) ){    //트럭이 남아있고 트럭+다리무게가 L보다 작거나 같으면
                bridge[0] = trucks.poll();  //다리에 새로운 트럭 올라감.
            }
            result++;
            if(isBridgeEmpty()){
                break;
            }
        }
        System.out.println(result);
    }

    static boolean isBridgeEmpty(){
        for(int i = 0; i < w; i++){
            if (bridge[i] != 0) return false;
        }
        return true;
    }

    static int calculate(){
        int sum = 0;
        for (int i = 0; i < w; i++) {
            sum += bridge[i];
        }
        return sum;
    }

    static void moveTruck(){
        for (int i = w - 1; i > 0; --i) {
            bridge[i] = bridge[i - 1];
        }
        bridge[0] = 0;
    }

}
