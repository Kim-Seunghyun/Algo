import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2583 {
	static int M, N, K;
	static boolean check[][], arr[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new boolean[M][N];
		check = new boolean[M][N];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int sX = Integer.parseInt(st.nextToken());
			int sY = Integer.parseInt(st.nextToken());
			int eX = Integer.parseInt(st.nextToken());
			int eY = Integer.parseInt(st.nextToken());
			eY = M - eY;
			eX--;
			sY = M - sY - 1;
			for (int y = eY; y <= sY; y++) {
				for (int x = sX; x <= eX; x++) {
					arr[y][x] = true;
				}
			}
		}
		PriorityQueue<Integer> pQueue = new PriorityQueue<>();
		Queue<int[]> queue = new LinkedList<int[]>();
		for (int y = 0; y < M; y++) {
			for (int x = 0; x < N; x++) {
				if (!arr[y][x] && !check[y][x]) {
					int score = 0;
					queue.offer(new int[] { y, x });
					check[y][x] = true;
					while (!queue.isEmpty()) {
						int cY = queue.peek()[0];
						int cX = queue.peek()[1];
						score++;
						queue.poll();
						for (int i = 0; i < 4; i++) {
							int nextY = cY + dir[i][0];
							int nextX = cX + dir[i][1];
							if (nextY < 0 || nextX < 0 || nextY >= M || nextX >= N)
								continue;
							if (check[nextY][nextX] || arr[nextY][nextX])
								continue;
							queue.offer(new int[] { nextY, nextX });
							check[nextY][nextX] = true;
						}
					}
					pQueue.offer(score);
				}
			}
		}
		sb.append(pQueue.size()).append("\n");
		while (!pQueue.isEmpty()) {
			sb.append(pQueue.poll()).append(" ");
		}
		System.out.print(sb);
	}

}
