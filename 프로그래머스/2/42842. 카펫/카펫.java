class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        
        for(int i = 1 ; i <= total/3 ; i++){
            if(total % i == 0) {
                int j = total / i ;
                int calBrown = 2*(i+j) - 4;
                if(calBrown == brown) {    
                    int calYellow = (i-2)*(j-2);
                    if(calYellow == yellow) {
                        answer[0] = Math.max(i,j);
                        answer[1] = Math.min(i,j);
                        break;
                    }    
                }
            } 
        }
        return answer;
    }
}