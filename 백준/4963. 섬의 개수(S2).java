import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ4963 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { -1, -1 }, { 1, -1 }, { -1, 1 } };
		int y = 0, x = 0;
		int[][] arr;
		Queue<int[]> queue;
		boolean[][] check;
		while (true) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			int cnt = 0;
			if (x == 0 && y == 0)
				break;
			arr = new int[y][x];
			check = new boolean[y][x];
			queue = new LinkedList<int[]>();
			for (int i = 0; i < y; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < x; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < y; i++) {
				for (int j = 0; j < x; j++) {
					if (!check[i][j] && arr[i][j] == 1) {
						queue.offer(new int[] { i, j });
						check[i][j] = true;
						cnt++;
						while (!queue.isEmpty()) {
							int tY = queue.peek()[0];
							int tX = queue.peek()[1];
							queue.poll();
							for (int k = 0; k < 8; k++) {
								int nextY = tY + dir[k][0];
								int nextX = tX + dir[k][1];
								if (nextY < 0 || nextX < 0 || nextY >= y || nextX >= x)
									continue;
								if (check[nextY][nextX] || arr[nextY][nextX] == 0)
									continue;
								queue.offer(new int[] { nextY, nextX });
								check[nextY][nextX] = true;
							}
						}
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}

}
