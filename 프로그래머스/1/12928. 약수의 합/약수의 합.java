class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int idx = 1 ; idx < n + 1 ; idx++){
            if(n % idx == 0){
                answer += idx;
            }
        }
        return answer;
    }
}