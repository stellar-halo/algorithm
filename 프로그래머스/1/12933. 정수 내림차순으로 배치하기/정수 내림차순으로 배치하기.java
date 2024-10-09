import java.util.*;
import java.io.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        String str = String.valueOf(n);
        String[] numList = new String[str.length()];
        
        for(int idx = 0 ; idx < str.length() ; idx++){
            numList[idx] = str.substring(idx, idx+1);
        }
        Arrays.sort(numList, Collections.reverseOrder());
        for(String num : numList){
            answer = answer * 10 + Integer.parseInt(num);
        }
        return answer;
    }
}