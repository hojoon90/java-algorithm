package com.algorithm.unclassified;

import java.io.*;
import java.util.*;

public class BOJ_20006 {
    static List<Room> rooms = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken()); // 플레이어 수
        int m = Integer.parseInt(st.nextToken()); // 방 최대 인원 수

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String id = st.nextToken();
            Player newPlayer = new Player(id, level);

            boolean assigned = false;
            for (Room room : rooms) {
                if (room.canJoin(newPlayer)) {
                    room.addPlayer(newPlayer);
                    assigned = true;
                    break;
                }
            }
            if (!assigned) {
                Room newRoom = new Room(level, m);
                newRoom.addPlayer(newPlayer);
                rooms.add(newRoom);
            }
        }

        printRooms();
    }

    // 방을 출력하는 메서드
    static void printRooms() {
        StringBuilder sb = new StringBuilder();
        for (Room room : rooms) {
            sb.append(room.isFull() ? "Started!\n" : "Waiting!\n");
            room.sortPlayers(); // ID 기준 정렬
            for (Player player : room.players) {
                sb.append(player.level).append(" ").append(player.id).append("\n");
            }
        }
        System.out.print(sb);
    }

    // 플레이어 클래스
    static class Player {
        String id;
        int level;

        public Player(String id, int level) {
            this.id = id;
            this.level = level;
        }
    }

    // 방 클래스
    static class Room {
        int baseLevel;
        int maxSize;
        List<Player> players;

        public Room(int baseLevel, int maxSize) {
            this.baseLevel = baseLevel;
            this.maxSize = maxSize;
            this.players = new ArrayList<>();
        }

        boolean canJoin(Player p) {
            return players.size() < maxSize &&
                    p.level >= baseLevel - 10 &&
                    p.level <= baseLevel + 10;
        }

        void addPlayer(Player p) {
            players.add(p);
        }

        void sortPlayers() {
            players.sort(Comparator.comparing(p -> p.id)); // ID 기준 오름차순 정렬
        }

        boolean isFull() {
            return players.size() == maxSize;
        }
    }
}