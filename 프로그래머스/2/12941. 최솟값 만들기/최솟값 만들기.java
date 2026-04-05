import java.util.*;

class Solution{
    public int solution(int[] A, int[] B){
        Arrays.sort(A);
        Arrays.sort(B);
        int answer = 0;
        
        for(int idx = 0 ; idx < A.length ; idx++){
            answer += A[idx] * B[B.length - 1 - idx];
        }

        return answer;
    }
}