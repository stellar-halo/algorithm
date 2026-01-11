import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Candidate dasom = new Candidate(1, Integer.parseInt(br.readLine()));
        int buy = 0;
        PriorityQueue<Candidate> candidates = new PriorityQueue<>();
        for (int n = 0; n < N - 1; n++) {
            int s = Integer.parseInt(br.readLine());
            candidates.offer(new Candidate(n, s));
        }

        while (!candidates.isEmpty()) {
            Candidate candidate = candidates.poll();
            int n = candidate.num;
            int s = candidate.supporter;

            if(dasom.supporter > s) break;
            candidates.add(new Candidate(n, s - 1));
            dasom.supporter++;
            buy++;
        }

        System.out.println(buy);
    }

    public static class Candidate implements Comparable<Candidate> {
        int num, supporter;

        Candidate(int num, int supporter) {
            this.num = num;
            this.supporter = supporter;
        }

        @Override
        public int compareTo(Candidate candidate){
            return candidate.supporter - this.supporter;
        }
    }
}
