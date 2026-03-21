import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static LinkedList<ROOM> rooms;
    static int M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        rooms = new LinkedList<>();

        int P = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int p = 0; p < P; p++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            String n = st.nextToken();
            findRoom(new PLAYER(l, n));
        }

        for (ROOM room : rooms) {
            if (room.players.size() == M) {
                System.out.println("Started!");
            } else {
                System.out.println("Waiting!");
            }
            Collections.sort(room.players);

            for (PLAYER player : room.players) {
                System.out.println(player.level + " " + player.name);
            }
        }
    }

    static void findRoom(PLAYER player) {
        for (ROOM room : rooms) {
            if (room.players.size() < M && Math.abs(room.standard - player.level) < 11) {
                room.players.add(player);
                return;
            }
        }
        LinkedList<PLAYER> players = new LinkedList<>();
        players.add(player);

        rooms.add(new ROOM(player.level, players));
        return;
    }

    static class PLAYER implements Comparable<PLAYER> {
        int level;
        String name;

        PLAYER(int level, String name) {
            this.level = level;
            this.name = name;
        }

        @Override
        public int compareTo(PLAYER o) {
            return this.name.compareTo(o.name);
        }
    }

    static class ROOM {
        int standard;
        LinkedList<PLAYER> players;

        ROOM(int standard, LinkedList<PLAYER> players) {
            this.standard = standard;
            this.players = players;
        }
    }
}

