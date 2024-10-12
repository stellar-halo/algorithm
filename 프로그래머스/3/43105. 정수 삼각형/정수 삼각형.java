class Solution {
    public int solution(int[][] triangle) {
        int height = triangle.length;
        int[] dp = new int[height];

        // 마지막 층을 초기화
        for (int j = 0; j < height; j++) {
            dp[j] = triangle[height - 1][j];
        }

        // 아래에서 위로 계산
        for (int i = height - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                // 현재 위치의 최대 합계를 업데이트
                dp[j] = triangle[i][j] + Math.max(dp[j], dp[j + 1]);
            }
        }

        // 최종 결과는 dp[0]에 저장됨
        return dp[0];
    }
}
