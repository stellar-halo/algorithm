class Solution {
    public long solution(long n) {
        long sqrt = (long) Math.sqrt(n);
        
        // n이 완전 제곱수인지 확인
        if (sqrt * sqrt != n) {
            return -1;
        } else {
            long next = sqrt + 1;
            return next * next; // 다음 완전 제곱수
        }
    }
}
