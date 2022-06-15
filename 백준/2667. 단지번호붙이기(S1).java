import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BJ2667 {
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		char[][] arr = new char[N][N];
		for (int i = 0; i < N; i++)
			arr[i] = br.readLine().toCharArray();
		Queue<int[]> queue = new LinkedList<int[]>();
		List<Integer> list = new LinkedList<>();
		boolean[][] check = new boolean[N][N];
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (arr[y][x] == '1' && !check[y][x]) {
					queue.offer(new int[] { y, x });
					check[y][x] = true;
					int cnt = BFS(queue, check, arr);
					list.add(cnt);
				}
			}
		}
		Collections.sort(list);
		sb.append(list.size()).append("\n");
		for (int num : list)
			sb.append(num).append("\n");
		System.out.println(sb);
	}

	private static int BFS(Queue<int[]> queue, boolean[][] check, char[][] arr) {
		int N = check.length;
		int cnt = 1;
		while (!queue.isEmpty()) {
			int y = queue.peek()[0];
			int x = queue.peek()[1];
			queue.poll();
			for (int i = 0; i < 4; i++) {
				int nextY = y + dir[i][0];
				int nextX = x + dir[i][1];
				if (nextY < 0 || nextX < 0 || nextY >= N || nextX >= N)
					continue;
				if (check[nextY][nextX])
					continue;
				if (arr[nextY][nextX] == '0')
					continue;
				queue.offer(new int[] { nextY, nextX });
				check[nextY][nextX] = true;
				cnt++;
			}
		}
		return cnt;
	}

}
