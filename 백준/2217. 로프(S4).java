import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2217 {
	static int[] sorted;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		sorted = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		mergeSort(arr, 0, N - 1);
		int max = 0;
		for (int num : arr) {
			if (max < num)
				max = num;
		}
		System.out.println(max);
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
			if (arr[l] >= arr[r]) {
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
			if (left == 0 && right == arr.length - 1)
				arr[i] = sorted[i] * (i + 1);
			else
				arr[i] = sorted[i];
		}
	}

}
