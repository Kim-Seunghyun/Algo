import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ7569 {
	static int M, N, H, cnt = 0, ripe = 0, unRipe = 0;
	static int[][][] arr;
	static int[][] dir = { { -1, 0, 0 }, { 1, 0, 0 }, { 0, -1, 0 }, { 0, 1, 0 }, { 0, 0, 1 }, { 0, 0, -1 } };
	static boolean[][][] check;
	static Queue<int[]> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		arr = new int[H][N][M];
		check = new boolean[H][N][M];
		queue = new LinkedList<int[]>();
		List<int[]> list = new LinkedList<>();
		int res = -1;
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					arr[h][i][j] = Integer.parseInt(st.nextToken());
					if (arr[h][i][j] == 0)
						unRipe++;
					else if (arr[h][i][j] == 1) {
						ripe++;
						list.add(new int[] { h, i, j });
					}
				}
			}
		}
		if (ripe > 0 && unRipe == 0) {
			System.out.println(0);
			return;
		}
		for (int tmp[] : list) {
			int h = tmp[0];
			int y = tmp[1];
			int x = tmp[2];
			queue.offer(new int[] { h, y, x, 0 });
			check[h][y][x] = true;
		}
		bfs();
		if (cnt > 0)
			res = cnt;
		if (unRipe > 0)
			System.out.println(-1);
		else
			System.out.println(res);
	}

	private static void bfs() {
		int score = 0;
		while (!queue.isEmpty()) {
			int h = queue.peek()[0];
			int y = queue.peek()[1];
			int x = queue.peek()[2];
			score = queue.peek()[3];
			if (arr[h][y][x] == 0)
				unRipe--;
			queue.poll();
			for (int i = 0; i < 6; i++) {
				int nextH = h + dir[i][0];
				int nextY = y + dir[i][1];
				int nextX = x + dir[i][2];
				if (nextH < 0 || nextH >= H || nextY < 0 || nextY >= N || nextX < 0 || nextX >= M)
					continue;
				if (check[nextH][nextY][nextX] || arr[nextH][nextY][nextX] != 0)
					continue;
				queue.offer(new int[] { nextH, nextY, nextX, score + 1 });
				check[nextH][nextY][nextX] = true;
			}
		}
		cnt = cnt > score ? cnt : score;
	}

}
