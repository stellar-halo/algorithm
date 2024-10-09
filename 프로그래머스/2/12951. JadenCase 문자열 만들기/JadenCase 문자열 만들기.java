import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) {
        int len = s.length();
        boolean isUpper = false;
        String answer = "";
        answer = answer + s.substring(0,1).toUpperCase();
        
        for(int idx = 1 ; idx < len ; idx++){
            String str = s.substring(idx,idx+1);
            if(str.equals(" ")){
                isUpper = true;
            }else{
                if(isUpper){
                    str = str.toUpperCase();
                    isUpper = false;
                }else{
                    str = str.toLowerCase();
                }
            }
            answer = answer + str;
        }
        return answer;
    }
}