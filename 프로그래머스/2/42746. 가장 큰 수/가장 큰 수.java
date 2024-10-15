import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        List<String> nums = new ArrayList<>();

        // 숫자를 문자열로 변환하여 리스트에 추가
        for (int n : numbers) {
            nums.add(String.valueOf(n));
        }

        // 정렬: 두 숫자 x, y에 대해 x+y와 y+x를 비교
        Collections.sort(nums, (o1, o2) -> {
            String xy = o1 + o2;
            String yx = o2 + o1;
            return yx.compareTo(xy); // 내림차순 정렬
        });

        // 결과 조합
        StringBuilder answer = new StringBuilder();
        for (String s : nums) {
            answer.append(s);
        }

        // 모든 숫자가 0인 경우 처리
        if (answer.charAt(0) == '0') {
            return "0";
        }

        return answer.toString();
    }
}
