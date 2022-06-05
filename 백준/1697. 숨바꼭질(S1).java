import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1697 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		BFS(N, K);

	}

	private static void BFS(int n, int k) {
		Queue<int[]> queue = new LinkedList<>();
		boolean visited[] = new boolean[100001];
		queue.offer(new int[] { n, 0 });
		visited[n] = true;
		int num;
		int cnt;
		while (!queue.isEmpty()) {
			num = queue.peek()[0];
			cnt = queue.peek()[1];
			queue.poll();
			if (num == k) {
				System.out.println(cnt);
				return;
			}
			if (num > 0 && !visited[num - 1]) {
				queue.offer(new int[] { num - 1, cnt + 1 });
				visited[num - 1] = true;
			}
			if (num < 100000 && !visited[num + 1]) {
				queue.offer(new int[] { num + 1, cnt + 1 });
				visited[num + 1] = true;
			}
			if (num <= 50000 && !visited[num * 2]) {
				queue.offer(new int[] { num * 2, cnt + 1 });
				visited[num * 2] = true;
			}
		}
	}

}
