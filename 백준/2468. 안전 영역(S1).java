import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2468 {
	static int N;
	static int res;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		int max = 0;
		int[][] arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (max < arr[i][j])
					max = arr[i][j];
			}
		}
		for (int i = 0; i < max; i++) {
			simulation(arr, i);
		}
		System.out.println(res);
	}

	private static void simulation(int[][] arr, int h) {
		int cnt = 0;
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[][] check = new boolean[N][N];

		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (!check[y][x] && arr[y][x] - h > 0) {
					queue.offer(new int[] { y, x });
					cnt++;
					check[y][x] = true;
					BFS(arr, queue, check, h);
				}
			}
		}
		res = res > cnt ? res : cnt;
	}

	private static void BFS(int[][] arr, Queue<int[]> queue, boolean[][] check, int h) {
		while (!queue.isEmpty()) {
			int y = queue.peek()[0];
			int x = queue.peek()[1];
			queue.poll();
			for (int i = 0; i < 4; i++) {
				int nextY = y + dir[i][0];
				int nextX = x + dir[i][1];
				if (nextY < 0 || nextX < 0 || nextY >= N || nextX >= N)
					continue;
				if (check[nextY][nextX] || arr[nextY][nextX] - h <= 0)
					continue;
				queue.offer(new int[] { nextY, nextX });
				check[nextY][nextX] = true;
			}
		}
	}

}
