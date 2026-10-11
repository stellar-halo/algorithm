import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        ArrayList<Integer> tmpAnswer = new ArrayList<>();
        int[] a = {1,2,3,4,5}; //5
        int[] b = {2,1,2,3,2,4,2,5}; //8
        int[] c = {3,3,1,1,2,2,4,4,5,5}; //10
        
        int[] cnt = new int[3];
        
        for(int i = 0 ; i < answers.length ; i++){
            int A = i % 5;
            int B = i % 8;
            int C = i % 10;
            
            if(answers[i] == a[A]) cnt[0]++;
            if(answers[i] == b[B]) cnt[1]++;
            if(answers[i] == c[C]) cnt[2]++;
        }
        
        int max = Math.max(Math.max(cnt[0], cnt[1]), cnt[2]);
        
        for(int idx = 0; idx < 3 ;idx++){
            if(max == cnt[idx]) tmpAnswer.add(idx + 1);
        }
        
        int[] answer = new int[tmpAnswer.size()];
        
        for(int idx = 0; idx < tmpAnswer.size() ;idx++){
            answer[idx] = tmpAnswer.get(idx);
        }
        
        return answer;
    }
}