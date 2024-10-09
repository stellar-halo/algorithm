import java.math.*;

class Solution {
    public int[] solution(long n) {
        String str = Long.toString(n); // long을 문자열로 변환
        int size = str.length(); // 문자열의 길이를 통해 배열 크기 결정
        int[] answer = new int[size];
        
        for(int idx = 0 ; idx < size ; idx++){
            int num = Integer.parseInt(str.substring(size-idx-1, size-idx));
            answer[idx] = num;
        }
        return answer;
    }
}