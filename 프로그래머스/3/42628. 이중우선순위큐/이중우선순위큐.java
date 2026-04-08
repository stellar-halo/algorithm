import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        LinkedList<Integer> pq = new LinkedList<>();
        
        for(String op : operations){
            String[] s = op.split(" ");
            int num = Integer.parseInt(s[1]);
            if(s[0].equals("I")){
                pq.add(num);
                Collections.sort(pq, Collections.reverseOrder());
            }else if(s[0].equals("D")){
                if(num < 0){
                    if(!pq.isEmpty()) pq.remove(pq.size()-1);
                } else{
                    if(!pq.isEmpty()) pq.remove(0);
                }
            }
        }
        
        int[] answer = new int[2];
        
        if(!pq.isEmpty()){
           answer[1] = pq.get(pq.size()-1);
           answer[0] = pq.get(0); 
        }
        
        return answer;
    }
}