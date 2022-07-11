import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ15651 {
	static int N, M;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sol(0, "");
		System.out.println(sb);
	}

	private static void sol(int cnt, String s) {
		if (cnt == M) {
			sb.append(s).append("\n");
			return;
		}
		for (int i = 1; i <= N; i++) {
			sol(cnt + 1, s + i + " ");
		}
	}

}
