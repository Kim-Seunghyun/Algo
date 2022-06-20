import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2193 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[91];
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 1;
		long res = solution(arr, N);
		System.out.println(res);
	}

	private static long solution(long[] arr, int n) {
		if (arr[n] != 0)
			return arr[n];
		return arr[n] = solution(arr, n - 1) + solution(arr, n - 2);
	}

}
