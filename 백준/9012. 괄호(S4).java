import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ9012 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Stack<Character> in = new Stack<>();
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			int len = s.length();
			boolean flag = true;
			for (int j = 0; j < len; j++) {
				if (s.charAt(j) == '(') {
					in.add(s.charAt(j));
				} else {
					if (in.size() != 0) {
						in.pop();
					} else {
						flag = false;
						break;
					}
				}
			}
			if (in.size() != 0) {
				flag = false;
				in.clear();
			}
			if (flag)
				sb.append("YES").append("\n");
			else
				sb.append("NO").append("\n");
		}
		System.out.println(sb);
	}

}
