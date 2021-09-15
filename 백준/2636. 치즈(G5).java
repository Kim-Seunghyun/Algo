import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ2636 {
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };

	// 상 하 좌 우 좌상 우상 좌하 우하
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken()); // 세로
		int col = Integer.parseInt(st.nextToken()); // 가로
		int[][] map = new int[row][col];
		int cnt = 0;
		for (int y = 0; y < row; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < col; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
				if (map[y][x] == 1)
					cnt++;
			} // 맵 입력하면서 치즈갯수 세기
		}
		Stack<int[]> stack = new Stack<>();
		stack.add(new int[] { 0, cnt }); // 초기 상태 입력
		melt(row, col, map, cnt, stack); // 시뮬레이션 시작
		int time = stack.peek()[0];
		int num = stack.peek()[1];
		stack.pop();
		if (!stack.isEmpty())
			num = stack.pop()[1];
		System.out.println(time);
		System.out.println(num);
	}

	private static void melt(int row, int col, int[][] map, int cheese, Stack<int[]> stack) {
		Queue<int[]> zeroQueue = new LinkedList<>();
		int cnt = 1;
		while (cheese > 0) {
			boolean isVisited[][] = new boolean[row][col];
			zeroQueue.offer(new int[] { 0, 0 }); // 왼쪽위에서 부터 시작
			isVisited[0][0] = true;
			map[0][0] = -1;
			while (!zeroQueue.isEmpty()) {
				int curY = zeroQueue.peek()[0];
				int curX = zeroQueue.peek()[1];
				zeroQueue.poll();
				for (int i = 0; i < 4; i++) {
					int nextY = curY + dir[i][0];
					int nextX = curX + dir[i][1];
					if (nextY < 0 || nextX < 0 || nextY >= row || nextX >= col)
						continue;
					if (isVisited[nextY][nextX])
						continue;
					if (map[nextY][nextX] == 1)
						continue;
					zeroQueue.offer(new int[] { nextY, nextX });
					map[nextY][nextX] = -1;
					isVisited[nextY][nextX] = true;
				} // 상하좌우 탐색해서 1인 치즈가 아니라면 모두 -1로 바꿔버리기
			} // 이렇게 하면 치즈안에 갇힌 공기 빼고는 모든 공기가 -1로 바뀜
			Queue<int[]> oneQueue = new LinkedList<>();
			for (int y = 0; y < row; y++) {
				for (int x = 0; x < col; x++) {
					if (map[y][x] == 1 && !isVisited[y][x]) { // 치즈를 발견하면
						for (int i = 0; i < 4; i++) {
							int nextY = y + dir[i][0];
							int nextX = x + dir[i][1];
							if (nextY < 0 || nextX < 0 || nextY >= row || nextX >= col)
								continue;
							if (map[nextY][nextX] == -1) { // 상하좌우중 인접한 곳에 -1인 공기 찾기
								oneQueue.offer(new int[] { y, x });
								isVisited[y][x] = true;
								map[y][x] = 2;
								cheese--;
								break;
							} // -1인 공기가 있다면 외곽부이므로 queue에 넣기
						}
						while (!oneQueue.isEmpty()) {
							int curY = oneQueue.peek()[0];
							int curX = oneQueue.peek()[1];
							oneQueue.poll();
							for (int i = 0; i < 8; i++) { // 찾은 외곽부 부터 인접한 곳들 탐색해나가기 시작
								int nextY = curY + dir[i][0];
								int nextX = curX + dir[i][1];
								if (nextY < 0 || nextX < 0 || nextY >= row || nextX >= col)
									continue;
								if (isVisited[nextY][nextX])
									continue;
								if (map[nextY][nextX] == 2 || map[nextY][nextX] == 0 || map[nextY][nextX] == -1)
									continue; // 이미 녹을 예정이거나, 공기거나, 갇힌 공기라면 지나가기
								if (map[nextY][nextX] == 1) {
									int tmpY = nextY;
									int tmpX = nextX; // 외곽부에 인접한 치즈 찾았다면
									for (int j = 0; j < 4; j++) {
										nextY = tmpY + dir[j][0];
										nextX = tmpX + dir[j][1];
										if (nextY < 0 || nextX < 0 || nextY >= row || nextX >= col)
											continue;
										if (map[nextY][nextX] == -1) { // 해당 치즈 부근에 -1 공기 있는지 탐색
											oneQueue.offer(new int[] { tmpY, tmpX });
											isVisited[tmpY][tmpX] = true;
											map[tmpY][tmpX] = 2;
											cheese--;
											break;
										} // -1 공기가 있다면 외곽부 이므로 queue에 넣기
									}
								}
							}
						}
					}
				}
			} // 맵 전체 탐색 끝
			stack.push(new int[] { cnt++, cheese }); // 결과 스택에 저장
		}
	}
}
