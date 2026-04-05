import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) {
        String[] ss = s.split(" ");
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int idx = 0 ; idx < ss.length; idx++){
            pq.add(Integer.parseInt(ss[idx]));
        }
        String answer = "";
        answer += pq.poll();
        while(pq.size() != 1){
            pq.poll();
        }
        
        answer += " " + pq.poll();
        return answer;
    }
}