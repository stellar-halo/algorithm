class Solution {
    static int[] fibo;
    public int solution(int n) {
        fibo = new int[n+1];
        int answer = getFibo(n) % 1234567;
        
        return answer;
    }
    
    public int getFibo(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(fibo[n] > 0) return fibo[n];
        
        fibo[n] = (getFibo(n-1) + getFibo(n-2)) % 1234567;
        
        return fibo[n];
    }
}