import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ16948 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] dir = { { -2, -1 }, { -2, 1 }, { 0, -2 }, { 0, 2 }, { 2, -1 }, { 2, 1 } };
		int N = Integer.parseInt(br.readLine());
		boolean check[][] = new boolean[N][N];
		Queue<int[]> queue = new LinkedList<int[]>();
		int sY, sX, dY, dX;
		st = new StringTokenizer(br.readLine());
		sY = Integer.parseInt(st.nextToken());
		sX = Integer.parseInt(st.nextToken());
		dY = Integer.parseInt(st.nextToken());
		dX = Integer.parseInt(st.nextToken());
		queue.offer(new int[] { sY, sX, 0 });
		check[sY][sX] = true;
		boolean flag = false;
		while (!queue.isEmpty()) {
			int y = queue.peek()[0];
			int x = queue.peek()[1];
			int cnt = queue.peek()[2];
			if (y == dY && x == dX) {
				System.out.println(cnt);
				flag = true;
				break;
			}
			queue.poll();
			for (int i = 0; i < 6; i++) {
				int nextY = y + dir[i][0];
				int nextX = x + dir[i][1];
				if (nextY < 0 || nextX < 0 || nextY >= N || nextX >= N)
					continue;
				if (check[nextY][nextX])
					continue;
				queue.offer(new int[] { nextY, nextX, cnt + 1 });
				check[nextY][nextX] = true;
			}
		}
		if (!flag)
			System.out.println(-1);
	}

}
