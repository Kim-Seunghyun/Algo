import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ17413 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		char[] in = br.readLine().toCharArray();
		int len = in.length;
		for (int i = 0; i < len; i++) {
			if (in[i] == '<') {
				popStack(sb, stack);
				int j = i;
				while (j < len) {
					sb.append(in[j]);
					if (in[j] == '>') {
						i = j;
						break;
					}
					j++;
				}
			} else if (in[i] == ' ') {
				popStack(sb, stack);
				sb.append(" ");
			} else {
				stack.add(in[i]);
			}
		}
		popStack(sb, stack);
		System.out.println(sb);
	}

	private static void popStack(StringBuilder sb, Stack<Character> stack) {
		while (!stack.isEmpty())
			sb.append(stack.pop());
	}

}
