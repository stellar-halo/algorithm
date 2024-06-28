import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int n, amount;
    private static int[][] favorFriendList, classRoom, blankSeats, favorFriends;
    private static Queue<Integer> q;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int studentNum = n * n;
        favorFriendList = new int[studentNum + 1][4];
        blankSeats = new int[n][n];
        favorFriends = new int[n][n];
        classRoom = new int[n][n];
        q = new LinkedList<>();
        StringTokenizer st;
        for (int i = 0; i < studentNum; i++) {
            st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());
            q.add(student);
            for (int j = 0; j < 4; j++) {
                int favor = Integer.parseInt(st.nextToken());
                favorFriendList[student][j] = favor;
            }
        }

        while (!q.isEmpty()) {
            int student = q.poll();
            blankSeats = new int[n][n];
            favorFriends = new int[n][n];
            findSeat(student);}

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int student = classRoom[i][j];
                int favorFriendsCount = 0;
                for (int k = 0; k < 4; k++) {
                    int nextY = i + dy[k];
                    int nextX = j + dx[k];
                    // 벽이 아니라면
                    if (nextY >= 0 && nextY < n && nextX >= 0 && nextX < n) {
                        for (int t = 0; t < 4; t++) {
                            // 좋아하는 친구 수를 조사
                            if (classRoom[nextY][nextX] == favorFriendList[student][t]) {
                                favorFriendsCount++;
                            }
                        }
                    }
                }

                if (favorFriendsCount == 0) {
                } else if (favorFriendsCount == 1) {
                    amount += 1;
                } else if (favorFriendsCount == 2) {
                    amount += 10;
                } else if (favorFriendsCount == 3) {
                    amount += 100;
                } else {
                    amount += 1000;
                }
            }
        }

        System.out.println(amount);
    }

    private static void findSeat(int student) {
        int favorFriendsCount = 0;
        int blankCount = 0;
        int seatX = 21;
        int seatY = 21;

        //해당 학생에 대해 각 자리에 대한 좋아하는 친구와 빈 자리 체크
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //자리 정보 초기화
                blankCount = 0;
                favorFriendsCount = 0;

                //해당 자리가 비어있다면
                if (classRoom[i][j] == 0) {
                    for (int k = 0; k < 4; k++) {
                        int nextY = i + dy[k];
                        int nextX = j + dx[k];
                        // 벽이 아니라면
                        if (nextY >= 0 && nextY < n && nextX >= 0 && nextX < n) {
                            for (int t = 0; t < 4; t++) {
                                // 좋아하는 친구 수를 조사
                                if (classRoom[nextY][nextX] == favorFriendList[student][t]) {
                                    favorFriendsCount++;
                                }
                            }

                            // 빈칸 수를 조사
                            if (classRoom[nextY][nextX] == 0) {
                                blankCount++;
                            }
                        }
                    }
                    //정보 저장
                    blankSeats[i][j] = blankCount;
                    favorFriends[i][j] = favorFriendsCount;
                    //자리 위치 갱신 여부 파악

                    //첫 가능한 좌석이라면 앉힘
                    if (seatX == 21) {
                        seatY = i;
                        seatX = j;
                    }
                    // 가능한 자리가 있었고 갱신해야 되는지 파악
                    else {
                        //기존의 자리에 대한 정보
                        int b = blankSeats[seatY][seatX];
                        int f = favorFriends[seatY][seatX];

                        //좋아하는 친구 수가 현재 자리가 더 많으면 갱신
                        if (f < favorFriendsCount) {
                            seatY = i;
                            seatX = j;
                        } else if (f == favorFriendsCount) {
                            // 같으면 빈 자리가 더 많으면 갱신
                            if (b < blankCount) {
                                seatY = i;
                                seatX = j;
                            }
                            //빈 자리도 같으면 갱신 x 행이 먼저 앞서고, 열이 먼저 앞서는 순으로 검사하기 때문에 갱신할 필요가 없음
                        }
                    }
                }
            }
        }

        // 자리에 학생을 앉힌다.
        classRoom[seatY][seatX] = student;
    }
}
