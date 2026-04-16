import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int t: tangerine){
            hm.put(t, hm.getOrDefault(t, 0) + 1);
        }
        
        // List로 변환 후 정렬
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(hm.entrySet());

        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        
        for(int i = 0; i<list.size();i++){
            if(k > 0){
                k -= list.get(i).getValue();
                answer++;
            }else{break;}
        }
        return answer;
    }
}