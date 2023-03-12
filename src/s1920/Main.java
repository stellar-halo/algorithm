package s1920;

import java.io.*;
import java.util.Arrays;

public class Main {
    static long[] a;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        a =  Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        int m = Integer.parseInt(br.readLine());
        long[] b = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        Arrays.sort(a);

        for (int idx = 0; idx < m; idx++) {
            bw.write(binarySearch(0, n-1, b[idx]) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static int binarySearch(int start, int end, long num) {
        if (start <= end) {
            int mid = (start + end) / 2;
            long midA = a[mid];
            if (num < midA) return binarySearch(start, mid - 1, num);
            else if (num == midA) return 1;
            else return binarySearch(mid + 1, end, num);
        }
        return 0;
    }
}

