class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int w = 0;
        int h = 0;
        
        for(int[] size: sizes){
            
            int max = Math.max(size[0], size[1]);
            int min = Math.min(size[0], size[1]);
            
            if(h == 0)  h = min;
            
            w = Math.max(w, max);
            h = Math.max(h, min);
        }
        answer = w * h;
        return answer;
    }
}