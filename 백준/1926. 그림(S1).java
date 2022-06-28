import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1926 {

	static int dir[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int N, M, cnt, res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < M; x++) {
				arr[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		boolean check[][] = new boolean[N][M];
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				if (!check[y][x] && arr[y][x] == 1) {
					solution(arr, check, y, x);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		System.out.println(res);
	}

	private static void solution(int[][] arr, boolean[][] check, int y, int x) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] { y, x });
		check[y][x] = true;
		int score = 0;
		while (!queue.isEmpty()) {
			int curY = queue.peek()[0];
			int curX = queue.peek()[1];
			score++;
			queue.poll();
			for (int i = 0; i < 4; i++) {
				int nextY = curY + dir[i][0];
				int nextX = curX + dir[i][1];
				if (nextY < 0 || nextX < 0 || nextY >= N || nextX >= M) {
					continue;
				}
				if (check[nextY][nextX] || arr[nextY][nextX] == 0)
					continue;
				queue.offer(new int[] { nextY, nextX });
				check[nextY][nextX] = true;
			}
		}
		res = res > score ? res : score;
	}

}
