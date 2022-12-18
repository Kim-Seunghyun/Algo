package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class T4179 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		char[][] map = new char[R][C];
		boolean visited[][] = new boolean[R][C];
		Queue<int[]> fire = new LinkedList<>();
		int jY = 0;
		int jX = 0;
		for (int i = 0; i < R; i++) {
			String in = br.readLine();
			for (int j = 0; j < C; j++) {
				char c = in.charAt(j);
				map[i][j] = c;
				if (c == 'J') {
					jY = i;
					jX = j;
				} else if (c == 'F') {
					fire.offer(new int[] { i, j });
				}
			}
		}
		Queue<int[]> queue = new LinkedList<int[]>();
		int[][] dir = { { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 0 } };
		queue.offer(new int[] { jY, jX, 0 });
		visited[jY][jX] = true;
		while (!queue.isEmpty()) {
			int len = queue.size();
			for (int q = 0; q < len; q++) {
				int y = queue.peek()[0];
				int x = queue.peek()[1];
				int cnt = queue.peek()[2];
				queue.poll();
				if (map[y][x] == 'F')
					continue;
				for (int i = 0; i < 4; i++) {
					int nextY = y + dir[i][0];
					int nextX = x + dir[i][1];
					if (nextY < 0 || nextX < 0 || nextY >= R || nextX >= C) {
						System.out.println(cnt + 1);
						return;
					}
					if (map[nextY][nextX] == '#' || map[nextY][nextX] == 'F' || visited[nextY][nextX])
						continue;
					queue.offer(new int[] { nextY, nextX, cnt + 1 });
					visited[nextY][nextX] = true;
				}
			}
			len = fire.size();
			for (int f = 0; f < len; f++) {
				int y = fire.peek()[0];
				int x = fire.peek()[1];
				fire.poll();
				for (int i = 0; i < 4; i++) {
					int nextY = y + dir[i][0];
					int nextX = x + dir[i][1];
					if (nextY < 0 || nextX < 0 || nextY >= R || nextX >= C)
						continue;
					if (map[nextY][nextX] == '#' || map[nextY][nextX] == 'F')
						continue;
					fire.offer(new int[] { nextY, nextX });
					map[nextY][nextX] = 'F';
				}
			}
		}
		System.out.println("IMPOSSIBLE ");
	}

}
