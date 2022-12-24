package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class T10610 {
	static char[] sorted;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();
		int len = arr.length;
		boolean flag = false;
		int sum = 0;
		for (int i = 0; i < len; i++) {
			int num = arr[i] - '0';
			if (!flag && num == 0)
				flag = true;
			sum += num;
		}
		if (!flag || sum % 3 != 0) {
			System.out.println(-1);
		} else {
			sorted = new char[len];
			mergeSort(arr, 0, len - 1);
			StringBuilder sb = new StringBuilder();
			for (char c : arr) {
				sb.append(c);
			}
			System.out.println(sb.toString());
		}
	}

	private static void mergeSort(char[] arr, int left, int right) {
		int mid;
		if (left < right) {
			mid = (left + right) / 2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);
			merge(arr, left, mid, right);
		}
	}

	private static void merge(char[] arr, int left, int mid, int right) {
		int l = left;
		int r = mid + 1;
		int idx = l;
		while (l <= mid && r <= right) {
			if (arr[l] - '0' < arr[r] - '0') {
				sorted[idx] = arr[r];
				r++;
				idx++;
			} else {
				sorted[idx] = arr[l];
				l++;
				idx++;
			}
		}
		while (r <= right) {
			sorted[idx] = arr[r];
			idx++;
			r++;
		}
		while (l <= mid) {
			sorted[idx] = arr[l];
			idx++;
			l++;
		}
		for (int i = left; i <= right; i++) {
			arr[i] = sorted[i];
		}
	}

}
