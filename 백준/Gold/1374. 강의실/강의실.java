import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int finish = -1;
        PriorityQueue<Lecture> lectures = new PriorityQueue<>();
        PriorityQueue<Classroom> classrooms = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());
        for (int n = 0; n < N; n++) {
            String[] temp = br.readLine().split(" ");
            lectures.add(new Lecture(Integer.parseInt(temp[1]), Integer.parseInt(temp[2])));
        }

        while (!lectures.isEmpty()) {
            Lecture l = lectures.poll();
            if (!classrooms.isEmpty()) {
                Classroom c = classrooms.peek();
                if (c.finish <= l.start) {
                    classrooms.poll();
                }
            }
            classrooms.add(new Classroom(l.start, l.finish));
        }


        System.out.println(classrooms.size());
    }

    public static class Lecture implements Comparable<Lecture> {
        int start, finish;

        Lecture(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }

        @Override
        public int compareTo(Lecture lecture) {
            if (this.start == lecture.start) {
                return this.finish - lecture.finish;
            }
            return this.start - lecture.start;
        }
    }
    public static class Classroom implements Comparable<Classroom> {
        int start, finish;

        Classroom(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }

        @Override
        public int compareTo(Classroom classroom) {
            return this.finish - classroom.finish;
        }
    }

}
