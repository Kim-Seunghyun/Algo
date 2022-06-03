import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11399 {
	static int[] sorted;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		sorted = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		mergeSort(arr, 0, N - 1);
		int num = 0;
		int cnt = 0;
		int iter = N;
		while (iter > 0) {
			num += iter-- * arr[cnt++];
		}
		System.out.println(num);
	}

	private static void mergeSort(int[] arr, int left, int right) {
		int mid;
		if (left < right) {
			mid = (left + right) / 2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);
			merge(arr, left, mid, right);
		}
	}

	private static void merge(int[] arr, int left, int mid, int right) {
		int l = left;
		int idx = l;
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
		if (l > mid) {
			while (r <= right) {
				sorted[idx] = arr[r];
				idx++;
				r++;
			}
		} else {
			while (l <= mid) {
				sorted[idx] = arr[l];
				idx++;
				l++;
			}
		}
		for (int i = left; i <= right; i++) {
			arr[i] = sorted[i];
		}
	}

}
