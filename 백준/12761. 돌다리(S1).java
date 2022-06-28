import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ12761 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int idx = 0;
		int A = Integer.parseInt(str[idx++]);
		int B = Integer.parseInt(str[idx++]);
		int N = Integer.parseInt(str[idx++]);
		int M = Integer.parseInt(str[idx++]);
		Queue<int[]> queue = new LinkedList<>();
		boolean check[] = new boolean[100001];
		queue.offer(new int[] { N, 0 });
		check[N] = true;
		while (!queue.isEmpty()) {
			int num = queue.peek()[0];
			int cnt = queue.peek()[1];
			if (num == M) {
				System.out.println(cnt);
				return;
			}
			queue.poll();
			if (num - 1 >= 0 && !check[num - 1]) {
				queue.offer(new int[] { num - 1, cnt + 1 });
				check[num - 1] = true;
			}
			if (num + 1 <= 100000 && !check[num + 1]) {
				queue.offer(new int[] { num + 1, cnt + 1 });
				check[num + 1] = true;
			}
			if (num - A >= 0 && !check[num - A]) {
				queue.offer(new int[] { num - A, cnt + 1 });
				check[num - A] = true;
			}
			if (num - B >= 0 && !check[num - B]) {
				queue.offer(new int[] { num - B, cnt + 1 });
				check[num - B] = true;
			}
			if (num + A <= 100000 && !check[num + A]) {
				queue.offer(new int[] { num + A, cnt + 1 });
				check[num + A] = true;
			}
			if (num + B <= 100000 && !check[num + B]) {
				queue.offer(new int[] { num + B, cnt + 1 });
				check[num + B] = true;
			}
			if (num * A >= 0 && num * A <= 100000 && !check[num * A]) {
				queue.offer(new int[] { num * A, cnt + 1 });
				check[num * A] = true;
			}
			if (num * B >= 0 && num * B <= 100000 && !check[num * B]) {
				queue.offer(new int[] { num * B, cnt + 1 });
				check[num * B] = true;
			}
		}
	}

}
