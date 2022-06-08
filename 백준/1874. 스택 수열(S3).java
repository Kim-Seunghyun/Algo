import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ1874 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int max = 0;
		int num = 0;
		int idx = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (max < arr[i])
				max = arr[i];
		}
		for (int i = 1; i <= max;) {
			while (i <= arr[idx]) {
				stack.push(i++);
				sb.append('+').append("\n");
			}
			num = stack.pop();
			if (num != arr[idx]) {
				System.out.println("NO");
				return;
			}
			sb.append('-').append("\n");
			idx++;
		}
		while (!stack.isEmpty()) {
			num = stack.pop();
			sb.append('-').append("\n");
			if (num != arr[idx]) {
				System.out.println("NO");
				return;
			}
			idx++;
		}
		System.out.println(sb);
	}

}
