package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class T2573 {
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][M];
		boolean[][] check;
		Queue<int[]> queue = new LinkedList<int[]>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int t = 0;
		while (true) {
			int cnt = 0;
			check = new boolean[N][M];
			for (int i = 1; i < N - 1; i++) {
				for (int j = 1; j < M - 1; j++) {
					if (check[i][j])
						continue;
					if (arr[i][j] > 0) {
						check[i][j] = true;
						queue.offer(new int[] { i, j });
						BFS(check, queue, arr);
						cnt++;
					}
				}
			}

			if (cnt >= 2) {
				System.out.println(t);
				return;
			}
			if (cnt == 0) {
				System.out.println(0);
				return;
			}
			t++;
		}
	}

	private static void BFS(boolean[][] check, Queue<int[]> queue, int[][] arr) {
		while (!queue.isEmpty()) {
			int y = queue.peek()[0];
			int x = queue.peek()[1];
			int cnt = 0;
			queue.poll();
			for (int i = 0; i < 4; i++) {
				int nextY = y + dir[i][0];
				int nextX = x + dir[i][1];
				if (nextY < 0 || nextX < 0 || nextY >= N || nextX >= M)
					continue;
				if (check[nextY][nextX])
					continue;
				if (arr[nextY][nextX] <= 0) {
					cnt++;
					continue;
				}
				check[nextY][nextX] = true;
				queue.offer(new int[] { nextY, nextX });
			}
			arr[y][x] -= cnt;
		}
	}

}
