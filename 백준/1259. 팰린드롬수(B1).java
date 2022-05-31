import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1259 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String in = "";
		while (true) {
			in = br.readLine();
			if (in.equals("0"))
				break;
			boolean palindrome = true;
			for (int i = 0, j = in.length() - 1; i < (in.length() + 1) / 2; i++, j--) {
				if (in.charAt(i) != in.charAt(j)) {
					palindrome = false;
					break;
				}
			}
			if (palindrome)
				sb.append("yes");
			else
				sb.append("no");
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
