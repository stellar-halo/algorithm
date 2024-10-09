class Solution {
    public double solution(int[] arr) {
        int s = arr.length;
        int sum = 0;
        for(int i = 0 ; i < s ; i++){
            sum += arr[i];
        }
        double answer =(double) sum / s;
        return answer;
    }
}