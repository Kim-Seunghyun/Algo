import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ7562 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int[][] dir = { { -2, 1 }, { -2, -1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 } };
		int N = Integer.parseInt(br.readLine());
		for (int n = 0; n < N; n++) {
			int L = Integer.parseInt(br.readLine());
			Queue<int[]> queue = new LinkedList<int[]>();
			boolean[][] check = new boolean[L][L];
			int sX, sY, dX, dY;
			st = new StringTokenizer(br.readLine());
			sY = Integer.parseInt(st.nextToken());
			sX = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			dY = Integer.parseInt(st.nextToken());
			dX = Integer.parseInt(st.nextToken());
			queue.offer(new int[] { sY, sX, 0 });
			check[sY][sX] = true;
			while (!queue.isEmpty()) {
				int y = queue.peek()[0];
				int x = queue.peek()[1];
				int cnt = queue.peek()[2];
				if (y == dY && x == dX) {
					sb.append(cnt).append("\n");
					break;
				}
				queue.poll();
				for (int i = 0; i < 8; i++) {
					int nextY = y + dir[i][0];
					int nextX = x + dir[i][1];
					if (nextY < 0 || nextX < 0 || nextY >= L || nextX >= L)
						continue;
					if (check[nextY][nextX])
						continue;
					queue.offer(new int[] { nextY, nextX, cnt + 1 });
					check[nextY][nextX] = true;
				}
			}
		}
		System.out.println(sb);
	}

}
