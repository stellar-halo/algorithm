import java.util.Stack;

class Solution {
    public int[] solution(int[] numbers) {
        int len = numbers.length;
        int[] answer = new int[len];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            // 현재 숫자가 스택의 마지막 숫자보다 클 때까지 pop
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i]; // 답변 배열에 현재 숫자 저장
            }
            stack.push(i); // 현재 숫자의 인덱스를 스택에 추가
        }

        // 스택에 남아 있는 인덱스는 오른쪽에 더 큰 수가 없으므로 -1로 설정
        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }

        return answer;
    }
}
