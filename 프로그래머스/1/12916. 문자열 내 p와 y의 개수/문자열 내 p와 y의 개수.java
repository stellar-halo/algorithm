import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int p = 0;
        int y = 0;

        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'p') {
                p++;
            } else if (s.charAt(i) == 'y') { // 'y'를 세기 위해 추가
                y++;
            }
        }
        
        // p와 y의 개수가 다르면 answer를 false로 설정
        if (p != y) {
            answer = false;
        }
        
        return answer;
    }
}
