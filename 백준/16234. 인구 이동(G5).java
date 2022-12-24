package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class T16234 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Queue<int[]> queue;
		boolean check[][];
		int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
		int day = 0;
		boolean flag;
		List<int[]> move;
		int sum;
		while (true) {
			queue = new LinkedList<int[]>();
			check = new boolean[N][N];
			flag = false;
			sum = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (check[i][j])
						continue;
					queue.offer(new int[] { i, j });
					check[i][j] = true;
					move = new LinkedList<>();
					move.add(new int[] { i, j });
					sum += arr[i][j];
					while (!queue.isEmpty()) {
						int y = queue.peek()[0];
						int x = queue.peek()[1];
						queue.poll();
						for (int k = 0; k < 4; k++) {
							int nextY = y + dir[k][0];
							int nextX = x + dir[k][1];
							if (nextY < 0 || nextX < 0 || nextY >= N || nextX >= N)
								continue;
							if (check[nextY][nextX])
								continue;
							if (isInRange(arr[y][x], arr[nextY][nextX], L, R)) {
								check[nextY][nextX] = true;
								flag = true;
								move.add(new int[] { nextY, nextX });
								sum += arr[nextY][nextX];
								queue.offer(new int[] { nextY, nextX });
							}
						}
					}
					int size = move.size();
					if (size > 1) {
						int n = sum / size;
						for (int[] tmp : move) {
							int y = tmp[0];
							int x = tmp[1];
							arr[y][x] = n;
						}
					}
					sum = 0;
				}
			}
			if (!flag) {
				System.out.println(day);
				return;
			}
			day++;
		}

	}

	private static boolean isInRange(int i, int j, int l, int r) {
		boolean res = false;
		int n = Math.abs(i - j);
		if (n >= l && n <= r) {
			res = true;
		}
		return res;
	}

}
