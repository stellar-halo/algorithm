import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] channels = new String[N];
        int KBS1 = 0;
        int KBS2 = 0;

        for (int n = 0; n < N; n++) {
            String channel = br.readLine();
            channels[n] = channel;

            if (channel.equals("KBS1")) KBS1 = n;
            if (channel.equals("KBS2")) KBS2 = n;
        }

        StringBuilder sb = new StringBuilder();

        sb.append("1".repeat(KBS1));
        sb.append("4".repeat(KBS1));

        if (KBS1 < KBS2) {
            sb.append("1".repeat(KBS2));
            sb.append("4".repeat(KBS2 - 1));
        } else {
            sb.append("1".repeat(KBS2 + 1));
            sb.append("4".repeat(KBS2));
        }

        System.out.println(sb);
    }
}

