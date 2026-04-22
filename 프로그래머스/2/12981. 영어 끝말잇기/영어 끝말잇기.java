import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        HashSet<String> set = new HashSet<>();
        
        for(int i = 0 ; i < words.length ; i++){
            if(set.contains(words[i])) {
                int a = i % n + 1;
                int b = (i + 1) % n == 0 ? (i+1) / n : (i+1) / n + 1;
                
                answer[0] = a;
                answer[1] = b;
                break;
            }
            
            if(i > 0){
                String prev = words[i-1];
                if(prev.charAt(prev.length() - 1) != words[i].charAt(0)){
                    int a = i % n + 1;
                    int b = (i + 1) % n == 0 ? (i+1) / n : (i+1) / n + 1;
                
                    answer[0] = a;
                    answer[1] = b;
                    break;
                }
            }
            set.add(words[i]);
        }

        return answer;
    }
}