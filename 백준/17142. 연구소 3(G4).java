import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ17142 {
	static int zero, N, K, arr[][], dir[][] = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static int res, len, virus[][];
	static Queue<int[]> queue;
	static boolean[][] check;
	static final int MAX = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		virus = new int[K][2];
		List<int[]> list = new LinkedList<int[]>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 0)
					zero++;
				else if (arr[i][j] == 2) {
					list.add(new int[] { i, j });
				}
			}
		}
		len = list.size();
		res = MAX;
		sol(list, 0, 0);
		if (res == MAX)
			res = -1;
		System.out.println(res);
	}

	private static void sol(List<int[]> list, int cnt, int start) {
		if (cnt == K) {
			queue = new LinkedList<>();
			check = new boolean[N][N];
			for (int tmp[] : virus) {
				queue.offer(new int[] { tmp[0], tmp[1], 0 });
				check[tmp[0]][tmp[1]] = true;
			}
			BFS();
			return;
		}
		for (int i = start; i < len; i++) {
			int tmp[] = list.get(i);
			virus[cnt][0] = tmp[0];
			virus[cnt][1] = tmp[1];
			sol(list, cnt + 1, i + 1);
		}
	}

	private static void BFS() {
		int score = 0;
		int tmp = 0;
		while (!queue.isEmpty()) {
			int y = queue.peek()[0];
			int x = queue.peek()[1];
			int cnt = queue.peek()[2];
			tmp = tmp > cnt ? tmp : cnt;
			if (res < tmp)
				return;
			if (arr[y][x] == 0)
				score++;
			if (zero == score) {
				res = res < tmp ? res : tmp;
			}
			queue.poll();
			for (int i = 0; i < 4; i++) {
				int nextY = y + dir[i][0];
				int nextX = x + dir[i][1];
				if (nextY < 0 || nextX < 0 || nextY >= N || nextX >= N)
					continue;
				if (check[nextY][nextX] || arr[nextY][nextX] == 1)
					continue;
				if (arr[nextY][nextX] == 0) {
					queue.offer(new int[] { nextY, nextX, cnt + 1 });
					check[nextY][nextX] = true;
				} else {
					queue.offer(new int[] { nextY, nextX, cnt + 1 });
					check[nextY][nextX] = true;
				}
			}
		}

	}

}
