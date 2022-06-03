import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10814 {
	static int[] sortedAge;
	static int[] sortedJoin;
	static String[] sortedName;
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] age = new int[N];
		int[] join = new int[N];
		sortedAge = new int[N];
		sortedJoin = new int[N];
		sortedName = new String[N];
		String[] name = new String[N];
		StringTokenizer st;
		sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			age[i] = Integer.parseInt(st.nextToken());
			join[i] = i;
			name[i] = st.nextToken();
		}
		mergeSort(age, join, name, 0, N - 1);
		System.out.println(sb);
	}

	private static void mergeSort(int[] age, int[] join, String[] name, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(age, join, name, left, mid);
			mergeSort(age, join, name, mid + 1, right);
			merge(age, join, name, left, mid, right);
		}
	}

	private static void merge(int[] age, int[] join, String[] name, int left, int mid, int right) {
		int l = left;
		int idx = l;
		int r = mid + 1;
		while (l <= mid && r <= right) {
			if (age[l] < age[r]) {
				sortedAge[idx] = age[l];
				sortedName[idx] = name[l];
				sortedJoin[idx] = join[l];
				idx++;
				l++;
			} else if (age[l] > age[r]) {
				sortedAge[idx] = age[r];
				sortedName[idx] = name[r];
				sortedJoin[idx] = join[r];
				idx++;
				r++;
			} else {
				if (join[l] < join[r]) {
					sortedAge[idx] = age[l];
					sortedName[idx] = name[l];
					sortedJoin[idx] = join[l];
					idx++;
					l++;
				} else {
					sortedAge[idx] = age[r];
					sortedName[idx] = name[r];
					sortedJoin[idx] = join[r];
					idx++;
					r++;
				}
			}
		}
		if (l > mid) {
			while (r <= right) {
				sortedAge[idx] = age[r];
				sortedName[idx] = name[r];
				sortedJoin[idx] = join[r];
				idx++;
				r++;
			}
		} else {
			while (l <= mid) {
				sortedAge[idx] = age[l];
				sortedName[idx] = name[l];
				sortedJoin[idx] = join[l];
				idx++;
				l++;
			}
		}
		for (int i = left; i <= right; i++) {
			if (left == 0 && right == age.length - 1) {
				sb.append(sortedAge[i]).append(" ").append(sortedName[i]).append("\n");
			} else {
				age[i] = sortedAge[i];
				name[i] = sortedName[i];
				join[i] = sortedJoin[i];
			}
		}
	}

}
