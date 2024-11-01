import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> hs = new HashSet<>();
        for(int n : nums){
            hs.add(n);
        }
        int n = nums.length / 2;
        if(hs.size() >= n) {answer = n;}
        else {answer = hs.size();}
        return answer;
    }
}