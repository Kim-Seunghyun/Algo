import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2609 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num1 = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());
		if (num1 < num2) {
			int tmp = num1;
			num1 = num2;
			num2 = tmp;
		}
		int gcd = GCD(num1, num2);
		int lcd = num1 * num2 / gcd;
		System.out.println(gcd);
		System.out.println(lcd);
	}

	private static int GCD(int num1, int num2) {
		int num = num1 % num2;
		while (num != 0) {
			int tmp = num2 % num;
			num2 = num;
			num = tmp;
		}
		return num2;
	}

}
