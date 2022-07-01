import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ16173 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] dir = { { 0, 1 }, { 1, 0 } };
		int[][] arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[][] check = new boolean[N][N];

		queue.offer(new int[] { 0, 0 });
		check[0][0] = true;
		while (!queue.isEmpty()) {
			int y = queue.peek()[0];
			int x = queue.peek()[1];
			if (y == N - 1 && x == N - 1) {
				System.out.println("HaruHaru");
				return;
			}
			queue.poll();
			int num = arr[y][x];
			for (int i = 0; i < 2; i++) {
				int nextY = y + num * dir[i][0];
				int nextX = x + num * dir[i][1];
				if (nextY < 0 || nextX < 0 || nextY >= N || nextX >= N)
					continue;
				if (check[nextY][nextX])
					continue;
				queue.offer(new int[] { nextY, nextX });
				check[nextY][nextX] = true;
			}
		}
		System.out.println("Hing");
	}

}
