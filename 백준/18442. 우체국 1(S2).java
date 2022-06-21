import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ18442 {
	static int V, P;
	static StringBuilder sb;
	static long MAX = Long.MAX_VALUE;
	static long result[], arr[], post[], L, min = MAX;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		V = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		L = Long.parseLong(st.nextToken());
		arr = new long[V];
		post = new long[P];
		result = new long[P];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < V; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		pick(0, 0);

		System.out.println(min);
		for (long num : result) {
			sb.append(num).append(" ");
		}
		System.out.println(sb);
	}

	private static void pick(int start, int cnt) {
		if (cnt == P) {
			getSum();
			return;
		}
		for (int i = start; i < V; i++) {
			post[cnt] = arr[i];
			pick(i + 1, cnt + 1);
		}
	}

	private static long getDistance(long x, long y) {
		return Long.min(Math.abs(x - y), L - Math.abs(x - y));
	}

	private static void getSum() {
		long res = 0;
		for (int i = 0; i < V; i++) {
			long score = MAX;
			for (int j = 0; j < P; j++) {
				if (score == 0)
					break;
				score = Long.min(score, getDistance(post[j], arr[i]));
			}
			res += score;
		}
		if (res < min) {
			min = res;
			result = post.clone();
		}
	}
}
