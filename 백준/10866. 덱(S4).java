import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ10866 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		List<Integer> deque = new LinkedList<Integer>();
		int N = Integer.parseInt(br.readLine());
		String com;
		int X;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			com = st.nextToken();
			if (com.equals("push_front")) {
				X = Integer.parseInt(st.nextToken());
				deque.add(0, X);
			} else if (com.equals("push_back")) {
				X = Integer.parseInt(st.nextToken());
				deque.add(X);
			} else if (com.equals("pop_front")) {
				if (!check(deque, sb))
					continue;
				sb.append(deque.get(0)).append("\n");
				deque.remove(0);
			} else if (com.equals("pop_back")) {
				if (!check(deque, sb))
					continue;
				sb.append(deque.get(deque.size() - 1)).append("\n");
				deque.remove(deque.size() - 1);
			} else if (com.equals("size")) {
				sb.append(deque.size()).append("\n");
			} else if (com.equals("empty")) {
				if (deque.size() == 0)
					sb.append(1);
				else
					sb.append(0);
				sb.append("\n");
			} else if (com.equals("front")) {
				if (!check(deque, sb))
					continue;
				sb.append(deque.get(0)).append("\n");
			} else {
				if (!check(deque, sb))
					continue;
				sb.append(deque.get(deque.size() - 1)).append("\n");
			}
		}
		System.out.println(sb);
	}

	private static boolean check(List<Integer> deque, StringBuilder sb) {
		if (deque.size() == 0) {
			sb.append(-1).append("\n");
			return false;
		}
		return true;
	}

}
