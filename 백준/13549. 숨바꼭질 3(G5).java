import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ13549 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		boolean[] check = new boolean[100001];
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] { N, 0 });
		check[N] = true;
		int min = Integer.MAX_VALUE;
		while (!queue.isEmpty()) {
			int c = queue.peek()[0];
			int cnt = queue.peek()[1];
			if (c == K) {
				min = min < cnt ? min : cnt;
			}
			queue.poll();
			if (c * 2 <= 100000 && !check[c * 2]) {
				queue.offer(new int[] { c * 2, cnt });
				check[c * 2] = true;
			}
			if (c - 1 >= 0 && !check[c - 1]) {
				queue.offer(new int[] { c - 1, cnt + 1 });
				check[c - 1] = true;
			}
			if (c + 1 <= 100000 && !check[c + 1]) {
				queue.offer(new int[] { c + 1, cnt + 1 });
				check[c + 1] = true;
			}

		}
		System.out.println(min);
	}

}
