import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> hm = new HashMap<>();
        
        // 의상 종류별로 개수 세기
        for (String[] cloth : clothes) {
            hm.put(cloth[1], hm.getOrDefault(cloth[1], 0) + 1);
        }
        
        int answer = 1;
        
        // 각 종류의 의상 개수 + 1 (입지 않는 경우 포함)
        for (int count : hm.values()) {
            answer *= (count + 1);
        }
        
        // 모든 의상을 입지 않는 경우를 제외
        return answer - 1;
    }
}
