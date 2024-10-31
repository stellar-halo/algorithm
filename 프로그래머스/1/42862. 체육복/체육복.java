import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        int[] reserveList = new int[n+2];
        
        Arrays.sort(lost);
        
        for(int r : reserve){
            reserveList[r] = 1;
        }
        
        for(int l : lost){
            if(reserveList[l] == 1){
                reserveList[l] = 100;
                answer++;
            }
        }
        
        for(int l : lost){
            if(reserveList[l] != 100){
                int idx = l - 1;
                if(reserveList[idx] == 1){
                    reserveList[idx] = 0;
                    answer++;
                }else{
                    idx = l + 1;
                    if(reserveList[idx] == 1){
                        reserveList[idx] = 0;
                        answer++;
                    }
                }
            }  
        }
        return answer;
    }
}