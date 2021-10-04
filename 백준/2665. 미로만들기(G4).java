import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ2665 {
	static int N;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static int[] score = { 1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		int[][] cost = new int[N][N];
		for (int i = 0; i < N; i++) {
			String in = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = in.charAt(j) - '0';
				cost[i][j] = Integer.MAX_VALUE;
			}
		}

		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] { 0, 0 });
		cost[0][0] = score[map[0][0]];
		while (!queue.isEmpty()) {
			int y = queue.peek()[0];
			int x = queue.peek()[1];
			queue.poll();
			for (int i = 0; i < 4; i++) {
				int nextY = y + dir[i][0];
				int nextX = x + dir[i][1];
				if (nextY < 0 || nextX < 0 || nextY >= N || nextX >= N)
					continue;
				if (cost[nextY][nextX] > score[map[y][x]] + cost[y][x]) {
					queue.offer(new int[] { nextY, nextX });
					cost[nextY][nextX] = score[map[y][x]] + cost[y][x];
				}
			}
		}
		System.out.println(cost[N - 1][N - 1]);
	}

}
