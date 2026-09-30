import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        int r = (int) 'R' - 65;
        int t = (int) 'T' - 65;
        int c = (int) 'C' - 65;
        int f = (int) 'F' - 65;
        int j = (int) 'J' - 65;
        int m = (int) 'M' - 65;
        int a = (int) 'A' - 65;
        int n = (int) 'N' - 65;
        int[] types = new int[26];
        //비동의 동의
        //1~3 -> 비동의 3~1 || 4 = 0 || 5~7 -> 동의 1~3
        //RT FC MJ AN
        
        for(int i = 0 ; i < survey.length ; i++){
            int idx = 0;
            int num = 0;
            if(choices[i] < 4){
                idx = (int)survey[i].charAt(0) - 65; //A: 65
                num = 4 - choices[i];
            }else if(choices[i] > 4){
                idx = (int)survey[i].charAt(1) - 65;
                num = choices[i] - 4;
            }            
            types[idx] = types[idx] + num;  
        }
        
        if(types[r] >= types[t]) answer += "R";
        else answer += "T";
        
        if(types[c] >= types[f]) answer += "C";
        else answer += "F";
        
        if(types[j] >= types[m]) answer += "J";
        else answer += "M";
        
        if(types[a] >= types[n]) answer += "A";
        else answer += "N";
        
        return answer;
    }
}