class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        
        for(int i = 0; i < n; i++) {
            // x를 long으로 변환하여 곱셈 수행
            long a = (long) x * (i + 1);
            answer[i] = a;
        }
        return answer;
    }
}
