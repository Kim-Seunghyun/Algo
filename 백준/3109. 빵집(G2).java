import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ3109 {
	static int res; //결과값 저장 변수
	static boolean end; //파이프 연결 시나리오 종료 변수

	static int[][] dir = { { -1, 1 }, { 0, 1 }, { 1, 1 } }; //우상, 우, 우하

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		char[][] map = new char[R][C];
		for (int y = 0; y < R; y++) {
			map[y] = br.readLine().toCharArray();
		}
    //입력완료
		stealPipe(map, R, C);
		System.out.println(res);
	}

	private static void stealPipe(char[][] map, int R, int C) {
		for (int y = 0; y < R; y++) { //모든 파이프 실행
			end = false;
			connectPipe(map, y, 0, R, C);
		}
	}

	private static void connectPipe(char[][] map, int y, int x, int R, int C) {
		if (x == C - 1) { // 끝에 도달했을 시
			res++; // 결과값 1 증가 시키고
			end = true; // 연결 시나리오 종료
			return;
		}
		for (int i = 0; i < 3; i++) {
			int nextY = y + dir[i][0];
			int nextX = x + dir[i][1];
			if (nextY < 0 || nextY >= R)
				continue; // y좌표 범위체크
			if (map[nextY][nextX] == 'x' || map[nextY][nextX] == '-')
				continue; // 갈 곳에 건물이 있거나, 파이프가 있는 경우 체크
			map[nextY][nextX] = '-'; // 없다면 파이프 놓기
			connectPipe(map, nextY, nextX, R, C); // 다음 좌표로 이동
			if (end)
				return; // 이 처리 안해주면 마지막 전 좌표에서 파이프 여러개 놓음
		}
	}

}
