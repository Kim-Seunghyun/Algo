import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1012 {
	static int width;
	static int height;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int i = 0; i < tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			width = Integer.parseInt(st.nextToken());
			height = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			int[][] arr = new int[height][width];
			int res = 0;
			boolean[][] isVisited = new boolean[height][width];
			for (int j = 0; j < num; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				arr[y][x] = 1;
			} // 입력완료
			for (int y = 0; y < height; y++) {
				for (int x = 0; x < width; x++) {
					if (arr[y][x] == 1 && isVisited[y][x] == false) {
						isVisited[y][x] = true;
						reculFind(x, y, arr, isVisited);
						res++;
					} // 아직 미방문인데 배추 심겨있으면 거기 모두 조사
				}
			}
			sb.append(res).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void reculFind(int x, int y, int[][] arr, boolean[][] isVisited) {
		int dir[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		for (int i = 0; i < 4; i++) {
			int nextX = x + dir[i][1];
			int nextY = y + dir[i][0];
			if (nextX < 0 || nextY < 0 || nextX >= width || nextY >= height)
				continue;
			if (arr[nextY][nextX] == 1 && isVisited[nextY][nextX] == false) {
				isVisited[nextY][nextX] = true;
				reculFind(nextX, nextY, arr, isVisited);
			}
		}
	}
}
