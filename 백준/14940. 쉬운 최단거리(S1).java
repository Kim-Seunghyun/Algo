import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ14940 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][m];
		int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
		int sX = 0, sY = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2) {
					sY = i;
					sX = j;
				}
			}
		}
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[][] check = new boolean[n][m];
		queue.offer(new int[] { sY, sX, 0 });
		check[sY][sX] = true;
		while (!queue.isEmpty()) {
			int y = queue.peek()[0];
			int x = queue.peek()[1];
			int cnt = queue.peek()[2];
			queue.poll();
			arr[y][x] = cnt;
			for (int i = 0; i < 4; i++) {
				int nextY = y + dir[i][0];
				int nextX = x + dir[i][1];
				if (nextY < 0 || nextX < 0 || nextY >= n || nextX >= m)
					continue;
				if (check[nextY][nextX] || arr[nextY][nextX] == 0)
					continue;
				queue.offer(new int[] { nextY, nextX, cnt + 1 });
				check[nextY][nextX] = true;
			}
		}
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < m; x++) {
				if (!check[y][x] && arr[y][x] > 0)
					arr[y][x] = -1;
				sb.append(arr[y][x]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
