import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2805 {
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] tree = new int[N];
		int max = 0;
		res = 0;
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			if (tree[i] > max)
				max = tree[i];
		}
		binarySearch(tree, 0, max, M);
	}

	private static void binarySearch(int[] trees, int left, int right, int M) {
		while (true) {
			long num = 0;
			int mid = (left + right) / 2;
			if (left == right) {
				System.out.println(mid);
				break;
			}
			for (int tree : trees) {
				if (mid < tree) {
					num += tree - mid;
				}
			}
			if (num >= M) {
				if (res < mid) {
					res = mid;
					left = mid;
				} else
					right = mid;
			} else {
				right = mid;
			}
		}

	}

}
