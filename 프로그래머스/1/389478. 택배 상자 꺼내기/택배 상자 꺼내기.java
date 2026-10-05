class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        //현재 박스 위치
        
        int numW = num % w == 0 ? w : num % w;
        int numH = num % w == 0 ? num / w : num / w + 1;
        
        int nW = n % w == 0 ? w : n % w;
        int nH = n % w == 0 ? n / w : n / w + 1;
        
        int numIdx = numW;
        int nIdx = nW;
        if(nH % 2 == 0 && numH % 2 != 0){ //맨 위에가 짝수층이고 구하려는 층이 홀수층이면
            numIdx = w - numW + 1;
            nIdx = nW;
        }
        
        if(nH % 2 != 0 && numH % 2 == 0){ //맨 위에가 홀수층이고 구하려는 층이 짝수층이면
            numIdx = w - numW + 1;
            nIdx = nW;
        }
        
        if(nIdx >= numIdx){
            answer = nH - numH + 1;
        }else{
            answer = nH - numH;
        }
        return answer;
    }
}