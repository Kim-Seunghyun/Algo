import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1240 {
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<int[]> list[] = new LinkedList[N + 1];
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			if (list[x] == null) {
				list[x] = new LinkedList<>();
			}
			if (list[y] == null) {
				list[y] = new LinkedList<>();
			}
			list[x].add(new int[] { y, w });
			list[y].add(new int[] { x, w });
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int res = search(list, x, y);
			sb.append(res).append("\n");
		}
		System.out.println(sb);
	}

	private static int search(List[] lists, int x, int y) {
		int res = 0;
		boolean[] check = new boolean[N + 1];
		Queue<int[]> queue = new LinkedList<>();
		check[x] = true;
		queue.offer(new int[] { x, 0 });
		while (!queue.isEmpty()) {
			int num = queue.peek()[0];
			int cnt = queue.peek()[1];
			queue.poll();
			if (num == y) {
				res = cnt;
				break;
			}
			List<int[]> list = lists[num];
			for (int[] k : list) {
				if (check[k[0]])
					continue;
				queue.offer(new int[] { k[0], cnt + k[1] });
				check[k[0]] = true;
			}
		}
		return res;
	}

}
