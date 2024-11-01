import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s : scoville){
            pq.add(s);
        }
        
        int min = pq.poll();
        while(min < K && (pq.size() >= 1)){
            int nxtMin = pq.poll();
            int mix = nxtMin*2 + min;
            pq.add(mix);
            min = pq.poll();
            answer++;
        }
              
        if(min < K) answer = -1;
        return answer;
    }
}