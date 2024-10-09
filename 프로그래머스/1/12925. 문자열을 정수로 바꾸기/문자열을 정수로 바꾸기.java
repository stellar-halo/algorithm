import java.util.*;
import java.io.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        boolean isNegative = false; // 음수 여부를 나타내는 변수 추가

        for (int idx = 0; idx < s.length(); idx++) {
            String str = s.substring(idx, idx + 1);
            if (str.equals("-")) {
                // 첫 번째 '-'만 음수로 처리
                if (idx == 0) {
                    isNegative = true;
                }
            } else if(str.equals("+")){
                if (idx == 0) {
                    isNegative = false;
                }
            } else {
                int i = Integer.parseInt(str);
                answer = answer * 10 + i;
            }
        }

        return isNegative ? -answer : answer; // 음수일 경우 부호 반전
    }
}
