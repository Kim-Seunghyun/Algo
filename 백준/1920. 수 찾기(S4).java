import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1920 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			int res = binarySearch(num, arr);
			sb.append(res).append("\n");
		}
		System.out.println(sb);
	}

	private static int binarySearch(int num, int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		int mid = (start + end) / 2;
		while (start != mid && mid != end) {
			if (arr[mid] > num) {
				end = mid;
				mid = (start + end) / 2;
			} else if (arr[mid] < num) {
				start = mid;
				mid = (start + end) / 2;
			} else
				return 1;
		}
		if (arr[start] == num || arr[end] == num)
			return 1;
		return 0;
	}

}
