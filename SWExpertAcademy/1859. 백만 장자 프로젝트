import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// br = new BufferedReader(new InputStreamReader(new
		// FileInputStream("input_1859.txt")));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= T; i++) {
			sb.append("#").append(i).append(" ");
			long res = 0;
			int N = Integer.parseInt(br.readLine());
			String[] arr = br.readLine().split(" ");
			int size = arr.length - 2;
			int prev = Integer.parseInt(arr[size + 1]);
			while (size >= 0) {
				int next = Integer.parseInt(arr[size]);
				if (prev > next)
					res = res + (prev - next);
				else {
					prev = next;
				}
				size--;
			}

			sb.append(res).append("\n");
		}
		System.out.println(sb.toString());
	}
}
