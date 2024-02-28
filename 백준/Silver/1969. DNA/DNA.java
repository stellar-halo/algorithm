import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static class MaxKeyValue {
        private final String key;
        private final int value;

        public MaxKeyValue(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        List<LinkedHashMap<String, Integer>> dnaList = new ArrayList<>();
        String answerKey = "";
        Integer answerValue = 0;

        for (int temp = 0; temp < m; temp++) { //dnaList 초기화
            LinkedHashMap<String, Integer> dnaMap = new LinkedHashMap<>();
            dnaMap.put("A", 0);
            dnaMap.put("C", 0);
            dnaMap.put("G", 0);
            dnaMap.put("T", 0);
            dnaList.add(dnaMap);
        }

        for (int temp = 0; temp < n; temp++) {
            String[] dnaStr = br.readLine().split("");
            processDnaStr(dnaList, dnaStr);
        }

        for (LinkedHashMap<String, Integer> dna : dnaList) {
            MaxKeyValue keyDna = findMaxKey(dna);
            answerKey += keyDna.key;
            answerValue += (n - keyDna.value);
        }

        bw.write(answerKey + "\n" + answerValue);
        bw.flush();
        bw.close();
        br.close();
    }

    private static void processDnaStr(List<LinkedHashMap<String, Integer>> dnaList, String[] dnaStr) {
        for (int i = 0; i < dnaStr.length; i++) {
            String nucleotide = dnaStr[i];
            Map<String, Integer> dnaMap = dnaList.get(i);

            int val = dnaMap.getOrDefault(nucleotide, 0);
            dnaMap.put(nucleotide, val + 1);
        }
    }

    private static MaxKeyValue findMaxKey(LinkedHashMap<String, Integer> hashMap) {
        if (hashMap == null || hashMap.isEmpty()) {
            return null; // 빈 HashMap이나 null 처리
        }

        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxKey = entry.getKey();
                maxValue = entry.getValue();
            }
        }
        return new MaxKeyValue(maxKey, maxValue);
    }
}
