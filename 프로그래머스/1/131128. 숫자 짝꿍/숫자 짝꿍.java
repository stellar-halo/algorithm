import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        int[] xNum = new int[10];
        int[] yNum = new int[10];
        StringBuilder answer = new StringBuilder(); // StringBuilder 사용
        int xLen = X.length();
        int yLen = Y.length();
        
        for(int i=0; i<X.length();i++){
           xNum[X.charAt(i)-48] += 1;
        }
        for(int i=0; i<Y.length();i++){
           yNum[Y.charAt(i)-48] += 1;
        }
        
        for(int idx = 9; idx >= 0; idx--) {
            int count = Math.min(xNum[idx], yNum[idx]);
            for(int tmp = 0; tmp < count; tmp++) {
                answer.append(idx); // StringBuilder에 추가
            }
        }
        
        if("".equals(answer.toString())){
           return "-1";
        }else if(answer.toString().charAt(0)==48){
           return "0";
        }else {
            return answer.toString();
        }
    }
}
