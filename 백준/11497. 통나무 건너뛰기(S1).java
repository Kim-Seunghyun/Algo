import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11497 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int[] arr;
		int[] sorted;
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			arr = new int[N];
			sorted = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			mergeSort(arr, sorted, 0, N - 1);
			int mid = N / 2;
			int l = mid;
			int r = mid + 1;
			int idx = 0;
			while (l >= 0 && r < N) {
				sorted[l] = arr[idx];
				idx++;
				l--;
				sorted[r] = arr[idx];
				idx++;
				r++;
			}
			while (l >= 0) {
				sorted[l] = arr[idx];
				idx++;
				l--;
			}
			while (r < N) {
				sorted[r] = arr[idx];
				idx++;
				r++;
			}
			int min = Math.abs(sorted[0] - sorted[N - 1]);
			for (int j = 0; j < N - 1; j++) {
				min = Integer.max(min, Math.abs(sorted[j] - sorted[j + 1]));
			}
			sb.append(min).append("\n");
		}
		System.out.println(sb);
	}

	private static void mergeSort(int[] arr, int[] sorted, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(arr, sorted, left, mid);
			mergeSort(arr, sorted, mid + 1, right);
			merge(arr, sorted, left, mid, right);
		}
	}

	private static void merge(int[] arr, int[] sorted, int left, int mid, int right) {
		int l = left;
		int idx = l;
		int r = mid + 1;
		while (l <= mid && r <= right) {
			if (arr[l] > arr[r]) {
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

}
