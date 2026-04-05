class Solution {
    public int solution(int n) {
        int sum = 0;
        int tmp = 1;
        int answer = 0;
        while(sum < n){
            sum += tmp++;
        }
        tmp--;
        while(sum > 0){
            if(sum <= n){
                if((n - sum) % tmp == 0){
                    answer++;
                }
            }
            sum -= tmp--;
        }
        return answer;
    }
}