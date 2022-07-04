import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;

public class BJ1406 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char in[] = br.readLine().toCharArray();
		int N = Integer.parseInt(br.readLine());
		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();
		for (char c : in) {
			left.add(c);
		}
		char arr[], c;
		for (int i = 0; i < N; i++) {
			arr = br.readLine().toCharArray();
			if (arr[0] == 'P') {
				c = arr[2];
				left.add(c);
			} else if (arr[0] == 'L') {
				if (left.size() == 0)
					continue;
				right.add(left.pop());
			} else if (arr[0] == 'D') {
				if (right.size() == 0)
					continue;
				left.add(right.pop());
			} else {
				if (left.size() == 0)
					continue;
				left.pop();
			}
		}
		while (!right.isEmpty()) {
			left.add(right.pop());
		}
		for (char i : left) {
			sb.append(i);
		}
		System.out.print(sb);
	}

}
