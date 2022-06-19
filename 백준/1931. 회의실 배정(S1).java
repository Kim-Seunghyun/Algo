import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1931 {
	static int[][] sorted;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int arr[][] = new int[N][2];
		sorted = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		mergeSort(arr, 0, N - 1);
		int cnt = 0;
		int time = 0;
		for (int i = 0; i < N; i++) {
			if (time <= arr[i][0]) {
				cnt++;
				time = arr[i][1];
			}
		}
		System.out.println(cnt);
	}

	private static void mergeSort(int[][] arr, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);
			merge(arr, left, mid, right);
		}
	}

	private static void merge(int[][] arr, int left, int mid, int right) {
		int l = left;
		int idx = l;
		int r = mid + 1;
		while (l <= mid && r <= right) {
			if (arr[l][1] < arr[r][1]) {
				sorted[idx][0] = arr[l][0];
				sorted[idx][1] = arr[l][1];
				idx++;
				l++;
			} else if (arr[l][1] > arr[r][1]) {
				sorted[idx][0] = arr[r][0];
				sorted[idx][1] = arr[r][1];
				idx++;
				r++;
			} else {
				if (arr[l][0] < arr[r][0]) {
					sorted[idx][0] = arr[l][0];
					sorted[idx][1] = arr[l][1];
					idx++;
					l++;
				} else {
					sorted[idx][0] = arr[r][0];
					sorted[idx][1] = arr[r][1];
					idx++;
					r++;
				}
			}
		}
		while (l <= mid) {
			sorted[idx][0] = arr[l][0];
			sorted[idx][1] = arr[l][1];
			idx++;
			l++;
		}
		while (r <= right) {
			sorted[idx][0] = arr[r][0];
			sorted[idx][1] = arr[r][1];
			idx++;
			r++;
		}
		for (int i = left; i <= right; i++) {
			arr[i][0] = sorted[i][0];
			arr[i][1] = sorted[i][1];
		}
	}

}
