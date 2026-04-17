import java.util.*;

class Solution {
    public int solution(int[] arr) {
        Arrays.sort(arr);
        
        int answer = arr[1];
        
        for(int i = 1 ; i < arr.length ; i++){
            int temp = answer * arr[i];
            while(temp >= arr[i]){
                int tmp = temp;
                for(int j = i ; j >= 0 ; j--){
                    if(tmp % arr[j] != 0){
                        tmp--;
                         break;
                    }
                }
                
                if(tmp == temp) answer = temp;
                temp--;
            }
        }
        
        return answer;
    }
}