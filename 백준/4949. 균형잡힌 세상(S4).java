import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ4949 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String in = br.readLine();
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack;
		while (in.charAt(0) != '.') {
			int len = in.length();
			boolean flag = false;
			stack = new Stack<>();
			for (int i = 0; i < len; i++) {
				if (in.charAt(i) == '(' || in.charAt(i) == '[') {
					stack.add(in.charAt(i));
				} else if (in.charAt(i) == ')' || in.charAt(i) == ']') {
					if (stack.isEmpty()) {
						flag = true;
						break;
					}
					char prev = stack.pop();
					if (in.charAt(i) == ')' && prev == '(' || in.charAt(i) == ']' && prev == '[')
						continue;
					else {
						flag = true;
						break;
					}

				}
			}
			if (!stack.isEmpty())
				flag = true;
			if (flag)
				sb.append("no").append("\n");
			else
				sb.append("yes").append("\n");
			in = br.readLine();
		}
		System.out.print(sb);
	}

}
