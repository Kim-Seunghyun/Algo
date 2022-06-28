import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ13565 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
		boolean flag = false;
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		char[][] arr = new char[M][N];
		boolean[][] check = new boolean[M][N];
		Queue<int[]> queue = new LinkedList<int[]>();
		for (int i = 0; i < M; i++)
			arr[i] = br.readLine().toCharArray();
		for (int i = 0; i < N; i++) {
			if (arr[0][i] == '0' && !check[0][i]) {
				queue.offer(new int[] { 0, i });
				check[0][i] = true;
				while (!queue.isEmpty()) {
					int y = queue.peek()[0];
					int x = queue.peek()[1];
					queue.poll();
					if (y == M - 1) {
						flag = true;
						break;
					}
					for (int j = 0; j < 4; j++) {
						int nextY = y + dir[j][0];
						int nextX = x + dir[j][1];
						if (nextY < 0 || nextX < 0 || nextY >= M || nextX >= N)
							continue;
						if (check[nextY][nextX] || arr[nextY][nextX] == '1')
							continue;
						queue.offer(new int[] { nextY, nextX });
						check[nextY][nextX] = true;
					}

				}
			}
			if (flag)
				break;
		}
		if (flag)
			System.out.println("YES");
		else
			System.out.println("NO");
	}

}
