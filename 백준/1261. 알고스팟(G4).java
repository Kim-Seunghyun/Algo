import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1261 {
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		int[][] cost = new int[N][M];
		for (int i = 0; i < N; i++) {
			String in = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = in.charAt(j);
				cost[i][j] = Integer.MAX_VALUE;
			}

		}
		System.out.println(bfs(map, cost));
	}

	private static int bfs(char[][] map, int[][] cost) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] { 0, 0 });
		cost[0][0] = map[0][0] - '0';
		while (!queue.isEmpty()) {
			int y = queue.peek()[0];
			int x = queue.peek()[1];
			queue.poll();
			for (int i = 0; i < 4; i++) {
				int nextY = y + dir[i][0];
				int nextX = x + dir[i][1];
				if (nextY < 0 || nextX < 0 || nextY >= N || nextX >= M)
					continue;
				if (cost[nextY][nextX] > (map[y][x] - '0') + cost[y][x]) {
					queue.offer(new int[] { nextY, nextX });
					cost[nextY][nextX] = (map[y][x] - '0') + cost[y][x];
				}
			}
		}
		return cost[N - 1][M - 1];
	}

}
