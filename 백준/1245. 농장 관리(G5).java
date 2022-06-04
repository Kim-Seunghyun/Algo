import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1245 {
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		cnt = 0;
		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < M; x++) {
				arr[y][x] = Integer.parseInt(st.nextToken());
				if (arr[y][x] == 0)
					visited[y][x] = true;
			}
		}
		Queue<int[]> queue = new LinkedList<int[]>();
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				if (!visited[y][x]) {
					queue.offer(new int[] { y, x });
					visited[y][x] = true;
					BFS(queue, arr, visited, N, M, arr[y][x]);
				}
			}
		}
		System.out.println(cnt);
	}

	private static void BFS(Queue<int[]> queue, int[][] arr, boolean[][] visited, int n, int m, int h) {
		boolean top = true;
		while (!queue.isEmpty()) {
			int y = queue.peek()[0];
			int x = queue.peek()[1];
			queue.poll();
			for (int i = 0; i < 8; i++) {
				int nextY = y + dir[i][0];
				int nextX = x + dir[i][1];
				if (nextY < 0 || nextX < 0 || nextY >= n || nextX >= m)
					continue;
				if (arr[nextY][nextX] > h)
					top = false;
				else if (!visited[nextY][nextX] && arr[nextY][nextX] == h) {
					queue.offer(new int[] { nextY, nextX });
					visited[nextY][nextX] = true;
				}
			}
		}
		if (top)
			cnt++;
	}

}
