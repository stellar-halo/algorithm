import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        
        for(int idx = n - 2 ; idx >= 0 ; idx --){
            if(prices[idx] < prices[idx + 1]){ // 1 2
                int tmp = idx;
                while(prices[tmp] >= prices[idx]){
                    tmp++;
                    if(tmp == n - 1) break;
                }
                answer[idx] = (tmp - idx);
            }else if(prices[idx] == prices[idx + 1]){ // 1 1
                answer[idx] = answer[idx + 1] + 1;
            }else{ // 2 1
                answer[idx] = 1;
            }
        }
        return answer;
    }
}