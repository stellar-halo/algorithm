import java.io.*;
import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int wantLen = want.length;
        int discountLen = discount.length;
        int round = discountLen - 9;
        HashMap<String, Integer> map = new HashMap<>();
        
        
        
        for(int i = 0 ; i < round ; i++){
            boolean isMember = false;
            for(int tmp = 0 ; tmp < wantLen ; tmp++){
              map.put(want[tmp],number[tmp]);
             }
            for(int j = 0;j<10;j++){
                int idx = i+j;
                int lastNum = map.getOrDefault(discount[idx],0);
                if(lastNum > 0){
                   isMember = true;
                    map.put(discount[idx],lastNum-1);
               }else{
                   isMember = false;
                   break;
                }
            }
            
            if(isMember) {
                answer++;
            }
        }
        return answer;
    }
}