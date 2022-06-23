import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2581 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int min = 10001;
		int sum = 0;
		boolean flag = false;
		for (int i = M; i <= N; i++) {
			if (check(i)) {
				if (!flag) {
					min = i;
					flag = true;
				}
				sum += i;
			}
		}
		if (!flag)
			System.out.println(-1);
		else {
			System.out.println(sum);
			System.out.println(min);
		}
	}

	private static boolean check(int n) {
		if (n == 1)
			return false;
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

}
