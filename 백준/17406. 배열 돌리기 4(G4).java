import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ17406 {
	static int N; //y좌표 크기
	static int M; //x좌표 크기
	static int res; //결과값

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		int[][] rcs = new int[R][3];  //R, C, S값을 저장할 배열
		boolean[][] check = null;     //회전시 방문했는지를 체크할 배열
		res = Integer.MAX_VALUE;
		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int x = 0; x < M; x++) {
				arr[y][x] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++)
				rcs[i][j] = Integer.parseInt(st.nextToken());
		}
		// 입력완료
		boolean[] isSelected = new boolean[R];  
		int[] numbers = new int[R]; //순열 뽑기를 위한 변수
		perm(0, R, isSelected, numbers, check, rcs, arr);
		// 순열 뽑으면서 spin 실행

		System.out.println(res);
	}

	private static void perm(int cnt, int R, boolean[] isSelected, int[] numbers, boolean[][] check, int[][] rcs,
			int[][] arr) {
		if (cnt == R) { 
			int[][] clone = new int[N][M];
			for (int k = 0; k < N; k++) {
				for (int l = 0; l < M; l++)
					clone[k][l] = arr[k][l];
			} //원래의 배열 복사
			for (int i = 0; i < R; i++) {
				int j = numbers[i];
				int r = rcs[j][0];
				int c = rcs[j][1];
				int s = rcs[j][2];
				check = new boolean[N][M];
				spinArray(c - s - 1, r - s - 1, clone, check, r - 1, c - 1, s);
			} //뽑은 순열에 대해 회전
			// 갱신
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				int num = 0;
				for (int j = 0; j < M; j++) {
					num = num + clone[i][j];
				}
//				System.out.println(num);
				if (min > num) {
					min = num;
				}
			}
			if (res > min) {
				res = min;
			}
			return;
		} else {
			for (int i = 0; i < R; i++) {
				if (isSelected[i] == true)
					continue;
				numbers[cnt] = i;
				isSelected[i] = true;
				perm(cnt + 1, R, isSelected, numbers, check, rcs, arr);
				isSelected[i] = false;
			}
		}
	}

	private static void spinArray(int x, int y, int[][] arr, boolean[][] check, int R, int C, int S) {
		if (x == C && y == R) { //회전 중심좌표 도달시 리턴
			return;
		}
		int[][] direction = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } }; // 하우상좌
		int tmp = arr[y][x];  //현재값 임시로 저장
		int dir = 0;
		boolean flag = false;
		int curX = x;
		int curY = y;
		if (check[y][x] == true)
			flag = true;
		while (!flag) {
			int nextX = curX + direction[dir][1];
			int nextY = curY + direction[dir][0];
			if (nextX < 0 || nextX >= M || nextY < 0 || nextY >= N || nextX < (C - S) || nextX > (C + S)
					|| nextY < (R - S) || nextY > (R + S)) {
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
			arr[curY][curX] = arr[nextY][nextX];  //현재 위치에 초기의 임시값 저장
			check[curY][curX] = true;
			curY = nextY;
			curX = nextX;
		}
		spinArray(x + 1, y + 1, arr, check, R, C, S); //다음 회전 실행
	}

}
