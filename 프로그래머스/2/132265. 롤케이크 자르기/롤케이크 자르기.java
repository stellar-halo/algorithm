import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        HashMap<Integer, Integer> lm = new HashMap<>();
        HashMap<Integer, Integer> rm = new HashMap<>();
        
        int len = topping.length;
        
        // 오른쪽 해시맵 초기화
        for (int i = 0; i < len; i++) {
            rm.put(topping[i], rm.getOrDefault(topping[i], 0) + 1);
        }
        
        // 왼쪽 해시맵에 추가하고 비교
        for (int cut = 0; cut < len; cut++) {
            // 현재 topping[cut]을 왼쪽 해시맵으로 이동
            lm.put(topping[cut], lm.getOrDefault(topping[cut], 0) + 1);
            
            // 오른쪽 해시맵에서 해당 topping의 개수를 감소
            int r = rm.get(topping[cut]);
            if (r == 1) {
                rm.remove(topping[cut]);
            } else {
                rm.put(topping[cut], r - 1);
            }
            
            // 두 해시맵의 크기가 같으면 answer 증가
            if (lm.size() == rm.size()) {
                answer++;
            }
        }
        
        return answer;
    }
}
