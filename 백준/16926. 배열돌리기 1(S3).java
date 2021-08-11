import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ16926 {
	static int N; //y크기
	static int M; //x크기

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		boolean[][] check;  //방문했는지 검사할 배열
		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int x = 0; x < M; x++) {
				arr[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		// 입력완료

		for (int i = 0; i < R; i++) {
			check = new boolean[N][M];
			spinArray(0, 0, arr, check, 0);
		}
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				sb.append(arr[y][x]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void spinArray(int x, int y, int[][] arr, boolean[][] check, int cnt) {
		if (cnt == N * M) //모든 값 변경 시 탈출
			return;
		int[][] direction = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // 우하좌상
		int tmp = arr[y][x];  //현재값 임시저장
		int dir = 0;
		boolean flag = false;
		int curX = x; //현재 x, y값
		int curY = y;
		if (check[y][x] == true)
			flag = true;
		while (!flag) {
			int nextX = curX + direction[dir][1];
			int nextY = curY + direction[dir][0];
			if (nextX < 0 || nextX >= M || nextY < 0 || nextY >= N) {
				dir++;
				if (dir >= 4) {
					arr[curY][curX] = tmp;
					break; // 통과불가
				}
				continue;
			}
			if (check[nextY][nextX] == true) {
				dir++;
				if (dir >= 4) {
					arr[curY][curX] = tmp;
					break; // 통과불가
				}
				continue;
			}
			// 진행 불가능한 경우 체크
			arr[curY][curX] = arr[nextY][nextX];
			check[curY][curX] = true;
			curY = nextY;
			curX = nextX;
			cnt++;
		}
		if (x + 1 < M && y + 1 < N)
			spinArray(x + 1, y + 1, arr, check, cnt);
	}

}
