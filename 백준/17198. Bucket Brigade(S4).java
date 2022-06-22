import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ17198 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int res = 0;
		int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
		char[][] arr = new char[10][10];
		for (int i = 0; i < 10; i++)
			arr[i] = br.readLine().toCharArray();
		int bY = 0, bX = 0, lY = 0, lX = 0;
		for (int y = 0; y < 10; y++) {
			for (int x = 0; x < 10; x++) {
				if (arr[y][x] == 'B') {
					bY = y;
					bX = x;
				} else if (arr[y][x] == 'L') {
					lY = y;
					lX = x;
				}
			}
		}
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[][] check = new boolean[10][10];
		queue.offer(new int[] { lY, lX, 0 });
		check[lY][lX] = true;
		while (!queue.isEmpty()) {
			int y = queue.peek()[0];
			int x = queue.peek()[1];
			int cnt = queue.peek()[2];
			if (y == bY && x == bX) {
				res = cnt;
				break;
			}
			queue.poll();
			for (int i = 0; i < 4; i++) {
				int nextY = y + dir[i][0];
				int nextX = x + dir[i][1];
				if (nextY < 0 || nextX < 0 || nextY >= 10 || nextX >= 10)
					continue;
				if (check[nextY][nextX] || arr[nextY][nextX] == 'R')
					continue;
				queue.offer(new int[] { nextY, nextX, cnt + 1 });
				check[nextY][nextX] = true;
			}
		}
		System.out.println(res - 1);
	}

}
