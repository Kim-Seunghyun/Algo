import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11004 {
	static int[] sorted;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		sorted = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		mergeSort(arr, 0, N - 1);
		System.out.println(arr[K - 1]);
	}

	private static void mergeSort(int[] arr, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);
			merge(arr, left, mid, right);
		}

	}

	private static void merge(int[] arr, int left, int mid, int right) {
		int l = left, idx = left;
		int r = mid + 1;
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
		for (int i = left; i <= right; i++)
			arr[i] = sorted[i];
	}

}
