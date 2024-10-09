class Solution {
    int answer;
    boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        answer = 0; // 초기값을 0으로 설정
        visited = new boolean[dungeons.length];
        enterD(k, 0, dungeons);
        return answer;
    }

    public void enterD(int k, int count, int[][] dungeons) {
        // 최대 던전 수 업데이트
        answer = Math.max(answer, count);
        
        for (int i = 0; i < dungeons.length; i++) {
            // 아직 방문하지 않았고, 체력이 던전의 최소 요구 체력보다 충분한 경우
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true; // 던전 방문 표시
                // 체력 감소 후 재귀 호출
                enterD(k - dungeons[i][1], count + 1, dungeons);
                visited[i] = false; // 던전 방문 해제
            }
        }
    }
}
