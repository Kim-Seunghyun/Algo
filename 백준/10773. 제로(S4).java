import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ10773 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		int num;
		for (int i = 0; i < N; i++) {
			num = Integer.parseInt(br.readLine());
			if (num == 0)
				stack.pop();
			else
				stack.push(num);
		}
		int res = 0;
		while (!stack.isEmpty()) {
			res += stack.pop();
		}
		System.out.println(res);
	}

}
