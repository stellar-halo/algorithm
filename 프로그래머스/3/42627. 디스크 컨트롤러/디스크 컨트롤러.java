import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int now = 0;
        int sum = 0;
        PriorityQueue<JOB> pq = new PriorityQueue<>();
        PriorityQueue<JOB2> pq2 = new PriorityQueue<>();
        
        for(int idx = 0 ; idx < jobs.length ; idx++){
            pq2.add(new JOB2(jobs[idx][1], jobs[idx][0], idx));
        }
        
        JOB2 job2 = pq2.poll();
        pq.add(new JOB(job2.work, job2.request, job2.idx));
        
        while(!pq.isEmpty()){
            JOB job = pq.poll();
            
            now = Math.max(now, job.request);
            now += job.work;
            sum += now - job.request;
        
            while(!pq2.isEmpty()){ //pq2가 비어있지 않으면 
                JOB2 j2 = pq2.peek(); //다음에 고려할 대상을 하나 가져온다
                if(j2.request <= now){  // 다음JOB이 지금 시간에서 요청 가능한 상태라면
                    
                    pq.add(new JOB(j2.work, j2.request, j2.idx)); //고려할 대상에 넣고
                    pq2.remove(); //제거
                }else if(pq.isEmpty()){ //일할 수 있는 시간이 아직 도래하기 전인데 pq에 아무것도 없다면
                    now = j2.request; //시간을 흘려보내고 
                    
                    pq.add(new JOB(j2.work, j2.request, j2.idx)); //고려할 대상에 넣고
                    pq2.remove(); //제거
                }else{ //pq가 빈 것도 아니고 요청 불가능한 상태면 while문 탈출
                    break;
                }
            }
        }
        
        answer = sum / jobs.length;
        
        return answer;
    }
    
    class JOB implements Comparable<JOB>{
        int work;
        int request;
        int idx;
        
        JOB(int work, int request, int idx){
            this.work = work;
            this.request = request;
            this.idx = idx;
        }
        
        
        @Override
        public int compareTo(JOB other) {        
            if(this.work == other.work){
                if(this.request == other.request){
                    return this.idx - other.idx;
                }else{
                    return  this.request - other.request;
                }
            }else{
                return this.work - other.work ;
            }
        }
        
    }
    
    class JOB2 implements Comparable<JOB2>{
        int work;
        int request;
        int idx;
        
        JOB2(int work, int request, int idx){
            this.work = work;
            this.request = request;
            this.idx = idx;
        }
        
        
        @Override
        public int compareTo(JOB2 other) {      
            if(this.request == other.request){
                if(this.work == other.work){
                    return this.idx - other.idx;
                }else{
                    return  this.work - other.work;
                }
            }else{
                return this.request - other.request ;
            }
        }
        
    }
}