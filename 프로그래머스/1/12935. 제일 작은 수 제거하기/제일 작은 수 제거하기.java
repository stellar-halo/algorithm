class Solution {
    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length - 1];
        int min = arr[0];
        int minIdx = 0;

        // 문법 수정
        if (arr.length == 1) {
            return new int[]{-1};
        } else {
            for (int i = 1; i < arr.length; i++) {
                if (min > arr[i]) {
                    minIdx = i;
                    min = arr[i];
                }
            }

            int idx = 0;
            for (int i = 0; i < arr.length; i++) {
                if (i != minIdx) {
                    answer[idx++] = arr[i];
                }
            }
        }

        return answer;
    }
}