import java.io.*;
import java.util.*;

public class Main {

    static class Point {
        int x, y, z;
        Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static long sq(long x) {
        return x * x;
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int N = fs.nextInt();
        Point[] points = new Point[N];
        for (int i = 0; i < N; i++) {
            points[i] = new Point(
                fs.nextInt(),
                fs.nextInt(),
                fs.nextInt()
            );
        }

        int M = fs.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int x = fs.nextInt();
            int y = fs.nextInt();
            int z = fs.nextInt();
            long r = fs.nextLong();
            long r2 = r * r;

            int cnt = 0;
            for (int j = 0; j < N; j++) {
                long dx = points[j].x - x;
                long dy = points[j].y - y;
                long dz = points[j].z - z;
                if (dx * dx + dy * dy + dz * dz <= r2) {
                    cnt++;
                }
            }
            sb.append(cnt).append('\n');
        }

        System.out.print(sb);
    }

    // 빠른 입력
    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in;

        FastScanner(InputStream in) {
            this.in = in;
        }

        int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c, sign = 1, val = 0;
            while ((c = read()) <= ' ') ;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }

        long nextLong() throws IOException {
            int c, sign = 1;
            long val = 0;
            while ((c = read()) <= ' ') ;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }
}
