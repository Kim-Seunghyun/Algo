import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int[][] direction = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상하좌우
		for (int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			char[][] map = new char[H][W];
			for (int h = 0; h < H; h++) {
				map[h] = br.readLine().toCharArray();
			}
			int N = Integer.parseInt(br.readLine());
			char[] userIn = new char[N];
			userIn = br.readLine().toCharArray();
			// 입력 완료
			sb.append("#").append(i).append(" ");
			int x = 0, y = 0;
			int dir = 0;
			//먼저 탱크의 위치와 방향부터 설정
			for (int h = 0; h < H; h++) {
				for (int w = 0; w < W; w++) {
					if (map[h][w] == '>' || map[h][w] == '<' || map[h][w] == 'v' || map[h][w] == '^') {
						if (map[h][w] == '>')
							dir = 3;
						else if (map[h][w] == '<')
							dir = 2;
						else if (map[h][w] == 'v')
							dir = 1;
						else if (map[h][w] == '^')
							dir = 0;
						y = h;
						x = w;
						break;
					}	
				}
			}
			// 탱크 찾기랑 방향잡기 완료
			for (int j = 0; j < N; j++) {
				int nextX;
				int nextY;
				switch (userIn[j]) {
				case 'S':
					nextX = x + direction[dir][1];
					nextY = y + direction[dir][0];
					if (nextX < 0 || nextY < 0 || nextX >= W || nextY >= H)
						break;
					if (!(map[nextY][nextX] == '*' || map[nextY][nextX] == '#')) {
						while (true) {
							nextX = nextX + direction[dir][1];
							nextY = nextY + direction[dir][0];
							if (nextX < 0 || nextY < 0 || nextX >= W || nextY >= H)
								break;// 포탄 사라짐
							if (map[nextY][nextX] == '#')
								break;
							if (map[nextY][nextX] == '*') {
								map[nextY][nextX] = '.';
								break; // 벽 뿌수기
							}
						}
					} // 통과할 수 있다면
					else {
						if (map[nextY][nextX] == '#')
							continue;
						else if (map[nextY][nextX] == '*') {
							map[nextY][nextX] = '.';
						} // 통과할 수 없다면
					}
					break;
				case 'U':
					dir = 0;
					map[y][x] = '^';
					nextX = x + direction[dir][1];
					nextY = y + direction[dir][0];
					if (nextX < 0 || nextY < 0 || nextX >= W || nextY >= H)
						break;
					if (map[nextY][nextX] == '.') {
						map[y][x] = '.';
						map[nextY][nextX] = '^';
						y = nextY;
						x = nextX;
					} // 평지라면 진출

					break;
				case 'D':
					dir = 1;
					map[y][x] = 'v';
					nextX = x + direction[dir][1];
					nextY = y + direction[dir][0];
					if (nextX < 0 || nextY < 0 || nextX >= W || nextY >= H)
						break;
					if (map[nextY][nextX] == '.') {
						map[y][x] = '.';
						map[nextY][nextX] = 'v';
						y = nextY;
						x = nextX;
					}
					break;
				case 'L':
					dir = 2;
					map[y][x] = '<';
					nextX = x + direction[dir][1];
					nextY = y + direction[dir][0];
					if (nextX < 0 || nextY < 0 || nextX >= W || nextY >= H)
						break;
					if (map[nextY][nextX] == '.') {
						map[y][x] = '.';
						map[nextY][nextX] = '<';
						y = nextY;
						x = nextX;
					}
					break;
				case 'R':
					dir = 3;
					map[y][x] = '>';
					nextX = x + direction[dir][1];
					nextY = y + direction[dir][0];
					if (nextX < 0 || nextY < 0 || nextX >= W || nextY >= H)
						break;
					if (map[nextY][nextX] == '.') {
						map[y][x] = '.';
						map[nextY][nextX] = '>';
						y = nextY;
						x = nextX;
					}
					break;
				default:
					break;
				}
			}
			for (int h = 0; h < H; h++) {
				for (int w = 0; w < W; w++) {
					sb.append(map[h][w]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}
