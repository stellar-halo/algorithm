class Solution {
    public int[] solution(String s) {
        int cnt = 0;
        int[] answer = new int[2];
        
        while(true){
            
            cnt = 0;
            String[] ss = s.split("");
            answer[0]++;
            
            for(int i = 0 ; i < ss.length ; i++){
                if(ss[i].equals("1")) cnt++;
                else answer[1]++;
            }
            
            if(cnt == 1) break;  
                
            s = "";
            while(cnt > 3){
                s = (cnt % 2) + s;
                cnt = cnt / 2;
            }     
            s = (cnt % 2) + s;  
            s = (cnt / 2) + s;
        }
        return answer;
    }
}