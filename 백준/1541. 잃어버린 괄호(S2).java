import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1541 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(br.readLine());
		StringBuilder number = new StringBuilder();
		int num = 0;
		int tmp = 0;
		boolean minus = false;
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) != '-' && sb.charAt(i) != '+') {
				number.append(sb.charAt(i));
			} else if (sb.charAt(i) == '-') {
				if (!minus)
					num += parseNumber(number);
				else
					tmp += parseNumber(number);
				num -= tmp;
				tmp = 0;
				minus = true;
			} else {
				if (!minus)
					num += parseNumber(number);
				else
					tmp += parseNumber(number);
			}
		}
		tmp += parseNumber(number);
		if (minus) {
			num -= tmp;
		} else
			num += tmp;
		System.out.println(num);
	}

	private static int parseNumber(StringBuilder number) {
		int res = Integer.parseInt(number.toString());
		number.delete(0, number.length());
		return res;
	}

}
