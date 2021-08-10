import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class M1226 {
	static int size = 16;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 10; i++) {
			br.readLine();
			char[][] map = new char[size][size];
			boolean[][] isVisited = new boolean[size][size];
			for (int j = 0; j < size; j++) {
				map[j] = br.readLine().toCharArray();
			}
			// 입력완료
			int x = 0, y = 0;
			for (int j = 0; j < size; j++) {
				for (int k = 0; k < size; k++) {
					if (map[j][k] == '2') {
						x = k;
						y = j;
						break;
					}
				}
			}
			// 출발 좌표 찾기
			sb.append("#").append(i).append(" ");
			int res = 0;
			if (bfs(map, x, y, isVisited))
				res = 1;
			sb.append(res).append("\n");
		}
		System.out.println(sb.toString());
	}

	static boolean bfs(char[][] map, int x, int y, boolean[][] isVisited) {
		Queue<int[]> queue = new LinkedList<>();
		int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상하좌우
		queue.offer(new int[] { x, y }); // 현재좌표 큐에 넣고 실행
		while (!queue.isEmpty()) { // 큐가 빌때까지(더 이상 탐색 불가능)
			int curX = queue.peek()[0];
			int curY = queue.peek()[1];
			queue.poll();
			isVisited[curY][curX] = true;
			for (int i = 0; i < 4; i++) {
				int nextX = curX + dir[i][1];
				int nextY = curY + dir[i][0];
				if (nextX < 0 || nextX >= size || nextY < 0 || nextY >= size) // 못가면 다음 방향
					continue;
				if (map[nextY][nextX] == '1') // 벽이면 다음방향
					continue;
				if (map[nextY][nextX] == '0' && isVisited[nextY][nextX] == false) // 안가본곳이면 큐에 넣기
					queue.offer(new int[] { nextX, nextY });
				if (map[nextY][nextX] == '3') // 도착지면 true 리턴
					return true;
			}
		}
		return false; // 못찾으면 false 리턴
	}
}
