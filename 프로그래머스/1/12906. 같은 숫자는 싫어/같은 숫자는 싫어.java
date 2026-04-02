import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int idx = 0 ; idx < arr.length ; idx++){
            if(idx == 0) list.add(arr[idx]);
            else{
                if(arr[idx-1] != arr[idx]) list.add(arr[idx]);
            }
        }
        
        
        int[] answer = new int[list.size()];
        
        for(int idx = 0; idx < list.size() ; idx++){
            answer[idx] = list.get(idx);
        }

        return answer;
    }
}