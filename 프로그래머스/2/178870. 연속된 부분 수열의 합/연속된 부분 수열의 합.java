class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int len = sequence.length;
        answer[0] = 0;
        answer[1] = len;
        Sliding[] s = new Sliding[len];
        
        for(int i = 0 ; i < len ; i++){
            if(i == 0){
                s[i] = new Sliding(0, 0, sequence[i]);
            }else{
                int newSum = s[i-1].sum + sequence[i];
                int newStart = s[i-1].start;
                while(newSum > k){
                    newSum = newSum - sequence[newStart];
                    newStart++;
                    if(newStart == i) break;
                }
                
                s[i] = new Sliding(newStart, i, newSum);
            }
            if(s[i].sum == k){
                if((answer[1] - answer[0]) > (s[i].end - s[i].start)){
                    answer[0] = s[i].start;
                    answer[1] = s[i].end;
                }
            }
        }
        return answer;
    }
}

class Sliding{
    int start;
    int end;
    int sum;
    
    Sliding(int start, int end, int sum){
        this.start = start;
        this.end = end;
        this.sum = sum;
    }
}