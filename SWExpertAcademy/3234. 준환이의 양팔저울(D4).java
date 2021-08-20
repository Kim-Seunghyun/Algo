import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class M3234 {
	static int res;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] weight = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
			}
			boolean[] isSelected = new boolean[N];
			res = facto(N);
//			scale(0, 0, N, weight, isSelected);
			init(weight, isSelected, N);
			sb.append("#").append(t).append(" ").append(res).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void init(int[] weight, boolean[] isSelected, int len) {
		for (int i = 0; i < len; i++) {
			isSelected[i] = true;
			scale(1, weight[i], 0, len, weight, isSelected);
			isSelected[i] = false;
		}
	}

	private static void scale(int cnt, int lSum, int rSum, int len, int[] weight, boolean[] isSelected) {
		if (cnt == len && rSum > 0) {
			res++;
			return;
		}

		for (int i = 0; i < len; i++) {
			if (isSelected[i])
				continue;
			isSelected[i] = true;
			scale(cnt + 1, lSum + weight[i], rSum, len, weight, isSelected);
			isSelected[i] = false;
			if (rSum + weight[i] <= lSum) {
				isSelected[i] = true;
				scale(cnt + 1, lSum, rSum + weight[i], len, weight, isSelected);
				isSelected[i] = false;
			}
		}
	}

	private static int facto(int n) {
		if (n == 1)
			return 1;
		if (n == 0)
			return 1;
		return n * facto(n - 1);
	}
}
