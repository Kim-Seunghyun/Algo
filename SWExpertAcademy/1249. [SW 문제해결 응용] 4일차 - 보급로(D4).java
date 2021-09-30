import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class M1249 {
	static int N;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };  //4방향 탐색

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());  //테스트 케이스 수
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());  //맵 크기
			int[][] map = new int[N][N];
			int[][] cost = new int[N][N]; //해당 칸으로의 이동 시 비용을 저장할 배열
			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = input.charAt(j) - '0';
					cost[i][j] = Integer.MAX_VALUE; //비용은 Integer MAX_VALUE로 초기화
				}
			}
			int res = bfs(map, cost);
			sb.append("#").append(t).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}

	private static int bfs(int[][] map, int[][] cost) {
		Queue<int[]> queue = new LinkedList<int[]>(); //y, x 저장 큐
		cost[0][0] = map[0][0];
		queue.offer(new int[] { 0, 0 });
		while (!queue.isEmpty()) {
			int y = queue.peek()[0];
			int x = queue.peek()[1];
			queue.poll();
			for (int i = 0; i < 4; i++) {
				int nextY = y + dir[i][0];
				int nextX = x + dir[i][1];
				if (nextY < 0 || nextX < 0 || nextY >= N || nextX >= N)
					continue; //범위 체크
				if (cost[nextY][nextX] > map[nextY][nextX] + cost[y][x]) {  //다음 칸에 저장된 비용보다 현재 내가 가질 비용이 적다면 갱신
					queue.offer(new int[] { nextY, nextX });
					cost[nextY][nextX] = map[nextY][nextX] + cost[y][x];
				}
			}
		}
		return cost[N - 1][N - 1];
	}

}
