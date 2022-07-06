import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2589 {
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static int res, N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		char[][] arr = new char[N][M];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				if (arr[y][x] == 'L')
					BFS(arr, y, x);
			}
		}
		System.out.println(res);
	}

	private static void BFS(char[][] arr, int y, int x) {
		int max = 0;
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean check[][] = new boolean[N][M];
		queue.offer(new int[] { y, x, 0 });
		check[y][x] = true;
		while (!queue.isEmpty()) {
			int cY = queue.peek()[0];
			int cX = queue.peek()[1];
			int cnt = queue.peek()[2];
			max = max >= cnt ? max : cnt;
			queue.poll();
			for (int i = 0; i < 4; i++) {
				int nextY = cY + dir[i][0];
				int nextX = cX + dir[i][1];
				if (nextY < 0 || nextX < 0 || nextY >= N || nextX >= M)
					continue;
				if (check[nextY][nextX] || arr[nextY][nextX] == 'W')
					continue;
				queue.offer(new int[] { nextY, nextX, cnt + 1 });
				check[nextY][nextX] = true;
			}
		}
		res = res > max ? res : max;
	}

}
