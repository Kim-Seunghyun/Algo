import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1003 {
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int i = 0; i < TC; i++) {
			arr = new int[41][2];
			arr[0][0] = 1;
			arr[0][1] = 0;
			arr[1][0] = 0;
			arr[1][1] = 1;
			int N = Integer.parseInt(br.readLine());
			int res[] = fibo(N);
			sb.append(res[0]).append(" ").append(res[1]).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static int[] fibo(int n) {
		if (n == 0) {
			return arr[0];
		}
		if (n == 1) {
			return arr[1];
		}
		if (arr[n][0] != 0 || arr[n][1] != 0) {
			return arr[n];
		}
		int x[] = fibo(n - 2);
		int y[] = fibo(n - 1);
		arr[n][0] = x[0] + y[0];
		arr[n][1] = x[1] + y[1];
		return arr[n];

	}

}
