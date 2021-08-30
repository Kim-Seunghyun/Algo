import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2564 {
	static int x; //전체 가로
	static int y; //전체 세로

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		int[][] shop = new int[N][2]; //가게 정보 저장
		int[] me = new int[2];  //내 위치 저장
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			shop[i][0] = Integer.parseInt(st.nextToken());
			shop[i][1] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		me[0] = Integer.parseInt(st.nextToken());
		me[1] = Integer.parseInt(st.nextToken());
		int res = 0;
		int[] direction = { 0, y, 0, x }; //1,2,3,4 는 각각 북 남 서 동
		int mX = 0, mY = 0;
		if (me[0] <= 2) { //북남 일 경우
			mY = direction[me[0] - 1];
			mX = me[1];
		} else {  //서동 일 경우
			mX = direction[me[0] - 1];
			mY = me[1];
		}
		for (int i = 0; i < N; i++) {
			int tX = 0, tY = 0;
			if (shop[i][0] <= 2) {
				tY = direction[shop[i][0] - 1];
				tX = shop[i][1];
			} else {
				tX = direction[shop[i][0] - 1];
				tY = shop[i][1];  //me 좌표 설정과 동일
			}
			int min = Integer.min(sige(mX, mY, tX, tY), bansige(mX, mY, tX, tY)); //시계, 반시계 회전 중 더 작은 값으로 갱신
			res += min;
		}
		System.out.println(res);
	}

	private static int bansige(int mX, int mY, int tX, int tY) {
		int[][] dir = { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } }; //왼,아래,오른,위 순으로 진행
		int cX = mX;
		int cY = mY;  //현재 x,y 좌표
		int i = 0;  //초기 방향
		if (mX == 0 && mY < y)
			i = 1;
		else if (mY == y && mX < x)
			i = 2;
		else if (mX == x && mY > 0)
			i = 3;
		int cnt = 0;
		while (!(cX == tX && cY == tY)) {
			int nX = cX + dir[i][1];
			int nY = cY + dir[i][0];
			if (nX > x || nX < 0 || nY > y || nY < 0) {
				i++;
				if (i > 3)
					i %= 4;
				continue;
			}
			cnt++;
			cX = nX;
			cY = nY;
		}
		return cnt;
	}

	private static int sige(int mX, int mY, int tX, int tY) {
		int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; //오른, 아래, 왼, 위 순으로 진행
		int cX = mX;
		int cY = mY;
		int i = 0;
		if (mX == 0 && mY > 0)
			i = 3;
		else if (mY == y && mX > 0)
			i = 2;
		else if (mX == x && mY < y)
			i = 1;
		int cnt = 0;
		while (!(cX == tX && cY == tY)) {
			int nX = cX + dir[i][1];
			int nY = cY + dir[i][0];
			if (nX > x || nX < 0 || nY > y || nY < 0) {
				i++;
				if (i > 3)
					i %= 4;
				continue;
			}
			cnt++;
			cX = nX;
			cY = nY;
		}
		return cnt;
	}

}
