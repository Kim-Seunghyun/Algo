import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1654 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		long end = 0, res = 0;
		long start = 1;
		int[] lanLine = new int[K];
		for (int k = 0; k < K; k++) {
			lanLine[k] = Integer.parseInt(br.readLine());
			if (end < lanLine[k])
				end = lanLine[k];
		}
		// 입력완료

		while (start <= end) {
			long mid = (start + end) / 2;
			if (isOverN(mid, lanLine, N)) {
				start = mid + 1;
				res = Long.max(res, mid);
			} else {
				end = mid - 1;
			}
		}
		System.out.println(res);
	}

	private static boolean isOverN(long mid, int[] arr, int N) {
		int cnt = 0;
		for (int lan : arr) {
			cnt += lan / mid;
		}
		if (cnt >= N)
			return true;
		return false;
	}

}
