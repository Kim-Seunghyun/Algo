import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ15654 {
	static int N, M;
	static StringBuilder sb;
	static int[] arr;
	static int[] sorted;
	static boolean[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		sorted = new int[N];
		check = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		mergeSort(0, N - 1);
		sol(0, "");
		System.out.println(sb);
	}

	private static void mergeSort(int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(left, mid);
			mergeSort(mid + 1, right);
			merge(left, mid, right);
		}
	}

	private static void merge(int left, int mid, int right) {
		int l = left, idx = left, r = mid + 1;
		while (l <= mid && r <= right) {
			if (arr[l] < arr[r]) {
				sorted[idx] = arr[l];
				idx++;
				l++;
			} else {
				sorted[idx] = arr[r];
				idx++;
				r++;
			}
		}
		while (l <= mid) {
			sorted[idx] = arr[l];
			idx++;
			l++;
		}
		while (r <= right) {
			sorted[idx] = arr[r];
			idx++;
			r++;
		}
		for (int i = left; i <= right; i++) {
			arr[i] = sorted[i];
		}
	}

	private static void sol(int cnt, String s) {
		if (cnt == M) {
			sb.append(s).append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			if (check[i])
				continue;
			check[i] = true;
			sol(cnt + 1, s + arr[i] + " ");
			check[i] = false;
		}
	}

}
