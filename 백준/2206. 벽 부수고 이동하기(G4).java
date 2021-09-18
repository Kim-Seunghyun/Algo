import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2206 {
	static int N;
	static int M;
	static int res;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		for (int y = 0; y < N; y++) {
			String ss = br.readLine();
			for (int x = 0; x < M; x++) {
				map[y][x] = ss.charAt(x);
			}
		}
		res = -1;
		BFS(map);
		System.out.println(res);
	}

	private static void BFS(char[][] map) {
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[][][] check = new boolean[N][M][2];
		queue.offer(new int[] { 0, 0, 0, 1 });
		check[0][0][0] = true;
		while (!queue.isEmpty()) {
			int y = queue.peek()[0];
			int x = queue.peek()[1];
			int k = queue.peek()[2];
			int cnt = queue.peek()[3];
			queue.poll();
			if (y == N - 1 && x == M - 1) {
				res = cnt;
				return;
			}
			for (int i = 0; i < 4; i++) {
				int nextY = y + dir[i][0];
				int nextX = x + dir[i][1];
				if (nextY < 0 || nextX < 0 || nextY >= N || nextX >= M)
					continue;
				if (check[nextY][nextX][k])
					continue;
				if (k < 1 && map[nextY][nextX] == '1' && !check[nextY][nextX][k + 1]) {
					queue.offer(new int[] { nextY, nextX, k + 1, cnt + 1 });
					check[nextY][nextX][k + 1] = true;
				}
				if (map[nextY][nextX] == '0') {
					queue.offer(new int[] { nextY, nextX, k, cnt + 1 });
					check[nextY][nextX][k] = true;
				}
			}
		}
	}

}
