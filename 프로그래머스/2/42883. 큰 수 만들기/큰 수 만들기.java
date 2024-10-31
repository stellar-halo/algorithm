import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int len = number.length();
        int removeCnt = k;
        int startIdx = 0;

        while (answer.length() < len - k) {
            char maxChar = '0'; // 최대값 초기화
            int maxIdx = startIdx;

            // 현재 위치에서 제거할 수 있는 범위 내에서 최대값 찾기
            for (int i = startIdx; i <= startIdx + removeCnt; i++) {
                if (i < len && number.charAt(i) > maxChar) {
                    maxChar = number.charAt(i);
                    maxIdx = i;
                }
            }

            // 최대값 추가
            answer.append(maxChar);

            // 인덱스 업데이트
            removeCnt -= (maxIdx - startIdx); // 제거할 숫자 수 업데이트
            startIdx = maxIdx + 1; // 다음 탐색 시작 인덱스
        }

        return answer.toString();
    }
}
