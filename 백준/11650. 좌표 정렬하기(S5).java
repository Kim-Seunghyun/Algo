import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11650 {
	static StringBuilder sb;
	static int[][] tmp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[i][0] = x;
			arr[i][1] = y;
		}
		tmp = new int[arr.length][2];
		mergeSort(arr, 0, N - 1);
		System.out.println(sb);
	}

	private static void mergeSort(int[][] arr, int left, int right) {
		int mid;
		if (left < right) {
			mid = (left + right) / 2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);
			merge(arr, left, mid, right);
		}

	}

	private static void merge(int[][] arr, int left, int mid, int right) {
		int i = left;
		int j = mid + 1;
		int idx = i;

		while (i <= mid && j <= right) {
			if (arr[i][0] < arr[j][0]) {
				tmp[idx][1] = arr[i][1];
				tmp[idx][0] = arr[i][0];
				idx++;
				i++;
			} else if (arr[i][0] == arr[j][0]) {
				if (arr[i][1] < arr[j][1]) {
					tmp[idx][1] = arr[i][1];
					tmp[idx][0] = arr[i][0];
					idx++;
					i++;
				} else {
					tmp[idx][1] = arr[j][1];
					tmp[idx][0] = arr[j][0];
					idx++;
					j++;
				}
			} else {
				tmp[idx][1] = arr[j][1];
				tmp[idx][0] = arr[j][0];
				idx++;
				j++;
			}
		}
		if (i > mid) {
			while (j <= right) {
				tmp[idx][0] = arr[j][0];
				tmp[idx][1] = arr[j][1];
				idx++;
				j++;
			}
		} else {
			while (i <= mid) {
				tmp[idx][0] = arr[i][0];
				tmp[idx][1] = arr[i][1];
				idx++;
				i++;
			}
		}
		for (int l = left; l <= right; l++) {
			if (left == 0 && right == arr.length - 1) {
				sb.append(tmp[l][0]).append(" ").append(tmp[l][1]).append("\n");
			} else {
				arr[l][0] = tmp[l][0];
				arr[l][1] = tmp[l][1];
			}
		}
	}
}
