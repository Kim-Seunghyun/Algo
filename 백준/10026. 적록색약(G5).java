import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ10026 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
		int N = Integer.parseInt(br.readLine());
		char arr[][] = new char[N][N];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		int cnt1 = 0, cnt2 = 0;
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[][][] check = new boolean[N][N][2];
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (!check[y][x][0] || !check[y][x][1]) {
					if (!check[y][x][1]) {
						check[y][x][1] = true;
						queue.offer(new int[] { y, x, 1 });
						cnt2++;
					}
					if (!check[y][x][0]) {
						check[y][x][0] = true;
						queue.offer(new int[] { y, x, 0 });
						cnt1++;
					}
					while (!queue.isEmpty()) {
						int cY = queue.peek()[0];
						int cX = queue.peek()[1];
						int idx = queue.peek()[2];
						queue.poll();
						for (int i = 0; i < 4; i++) {
							int nextY = cY + dir[i][0];
							int nextX = cX + dir[i][1];
							if (nextY < 0 || nextX < 0 || nextY >= N || nextX >= N)
								continue;
							if (check[nextY][nextX][idx])
								continue;
							if (arr[y][x] != arr[nextY][nextX]) {
								if (idx == 1 && (arr[y][x] == 'G' || arr[y][x] == 'R')
										&& (arr[nextY][nextX] == 'G' || arr[nextY][nextX] == 'R')) {
									queue.offer(new int[] { nextY, nextX, idx });
									check[nextY][nextX][idx] = true;
								}
								continue;
							}
							queue.offer(new int[] { nextY, nextX, idx });
							check[nextY][nextX][idx] = true;
						}
					}
				}
			}
		}
		System.out.println(cnt1 + " " + cnt2);
	}
}
