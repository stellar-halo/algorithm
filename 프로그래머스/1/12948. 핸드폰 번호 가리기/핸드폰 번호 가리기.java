import java.util.*;

class Solution {
    public String solution(String phone_number) {
        int len = phone_number.length();
        char[] nums = phone_number.toCharArray();
        
        for(int idx = 0 ; idx < len - 4 ; idx++){
            nums[idx] = '*';
        }
        String answer = String.valueOf(nums);
        return answer;
    }
}