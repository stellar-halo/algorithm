import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int answer = 0;
        int start = 0;
        int end = people.length - 1;
        
        while(start <= end){
            if(start == end){
                answer = answer+1;
                end = end-1;
                start = start+1;
            }else{
                int sum = people[start] + people[end];
                if(sum > limit){
                   answer = answer+1;
                   end = end-1;
                }else{
                    answer = answer+1;
                    end = end-1;
                    start = start+1;
               }
            }
        }
        
        return answer;
    }
}