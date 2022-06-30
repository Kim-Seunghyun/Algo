import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2638 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] arr = new char[N][M];
		int total = 0;
		Queue<int[]> queue = new LinkedList<int[]>();
		for (int i = 0; i < N; i++) {
			String in = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = in.charAt(j * 2);
				if (arr[i][j] == '1')
					total++;
			}
		}
		int res = 0;
		while (total > 0) {
			boolean outer[][] = new boolean[N][M];
			for (int y = 0; y < N; y++) {
				queue.offer(new int[] { y, 0 });
				outer[y][0] = true;
				while (!queue.isEmpty()) {
					int cY = queue.peek()[0];
					int cX = queue.peek()[1];
					queue.poll();
					for (int i = 0; i < 4; i++) {
						int nextY = cY + dir[i][0];
						int nextX = cX + dir[i][1];
						if (nextY < 0 || nextX < 0 || nextY >= N || nextX >= M)
							continue;
						if (outer[nextY][nextX] || arr[nextY][nextX] == '1')
							continue;
						queue.offer(new int[] { nextY, nextX });
						outer[nextY][nextX] = true;
					}
				}
			}
			for (int x = 0; x < M; x++) {
				queue.offer(new int[] { 0, x });
				outer[0][x] = true;
				while (!queue.isEmpty()) {
					int cY = queue.peek()[0];
					int cX = queue.peek()[1];
					queue.poll();
					for (int i = 0; i < 4; i++) {
						int nextY = cY + dir[i][0];
						int nextX = cX + dir[i][1];
						if (nextY < 0 || nextX < 0 || nextY >= N || nextX >= M)
							continue;
						if (outer[nextY][nextX] || arr[nextY][nextX] == '1')
							continue;
						queue.offer(new int[] { nextY, nextX });
						outer[nextY][nextX] = true;
					}
				}
			}
			List<int[]> list = new LinkedList<>();

			for (int y = 1; y < N; y++) {
				for (int x = 1; x < M; x++) {
					if (arr[y][x] == '1') {
						int cnt = 0;
						for (int i = 0; i < 4; i++) {
							if (cnt >= 2)
								break;
							int nextY = y + dir[i][0];
							int nextX = x + dir[i][1];
							if (outer[nextY][nextX] && arr[nextY][nextX] == '0')
								cnt++;
						}
						if (cnt >= 2)
							list.add(new int[] { y, x });
					}
				}
			}

			for (int[] tmp : list) {
				int y = tmp[0];
				int x = tmp[1];
				arr[y][x] = '0';
				total--;
			}
			res++;
		}
		System.out.println(res);
	}

}
