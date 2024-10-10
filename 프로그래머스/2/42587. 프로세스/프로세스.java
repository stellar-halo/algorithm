import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Process> q = new LinkedList<>();
        int len = priorities.length;

        // Queue에 프로세스를 추가
        for (int idx = 0; idx < len; idx++) {
            q.add(new Process(priorities[idx], idx));
        }

        while (!q.isEmpty()) {
            Process p = q.poll();
            boolean hasHigherPriority = false;

            // 큐 내의 다른 프로세스와 비교
            for (Process other : q) {
                if (other.priorities > p.priorities) {
                    hasHigherPriority = true;
                    break;
                }
            }

            // 더 높은 우선순위가 있는 경우 다시 큐에 추가
            if (hasHigherPriority) {
                q.add(p);
            } else {
                // 현재 프로세스가 처리된 경우
                answer++;
                if (p.name == location) {
                    break;
                }
            }
        }

        return answer;
    }
}

class Process {
    int priorities;
    int name;

    Process(int priorities, int name) {
        this.priorities = priorities;
        this.name = name;
    }
}
