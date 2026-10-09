class Solution {
    static int answer;
    static int len; 
    static int diff; 
    
    public int solution(int[] numbers, int target) {
        int sum = 0;
        answer = 0;
        len = numbers.length;
        
        for(int n : numbers){
            sum += n;
        }
        
        diff = (sum - target) / 2;
        
        if((sum - target) % 2 != 0) return 0;
        if((sum - target) < 0) return 0;
        
        add(0, 0, numbers); 
        

        return answer;
    }
    
    public void add(int start, int sum, int[] numbers){
        if(sum == diff) {
            answer++;
            return;
        }
        
        if(start >= len) return;

        add(start+1, sum + numbers[start], numbers);
        add(start+1, sum, numbers);
       
        return;
    }
}