import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ11726 {
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		int res = calSum(N);
		System.out.println(res);
	}

	private static int calSum(int n) {
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		if (arr[n] != 0)
			return arr[n];
		return arr[n] = (calSum(n - 1) + calSum(n - 2)) % 10007;
	}

}
