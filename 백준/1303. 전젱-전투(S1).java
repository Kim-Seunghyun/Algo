import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1303 {
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };  
  //상 하 좌 우
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[M][N];
		int wCnt = 0;
		int bCnt = 0;
		for (int i = 0; i < M; i++)
			map[i] = br.readLine().toCharArray();
		boolean[][] check = new boolean[M][N];
		Queue<int[]> queue = new LinkedList<int[]>();

		for (int y = 0; y < M; y++) {
			for (int x = 0; x < N; x++) {  //전체 배열 돌려서
				if (!check[y][x]) { //아직 탐색 안한곳이면
					queue.offer(new int[] { y, x });  //큐에 넣고 방문체크
					check[y][x] = true; 
				}
				int cnt = 0;
				char cur = map[y][x]; //현재 색 저장
				while (!queue.isEmpty()) {
					int curY = queue.peek()[0];
					int curX = queue.peek()[1];
					queue.poll();
					cnt++;
					for (int i = 0; i < 4; i++) {
						int nextY = curY + dir[i][0];
						int nextX = curX + dir[i][1];
						if (nextY < 0 || nextX < 0 || nextY >= M || nextX >= N)
							continue;
						if (check[nextY][nextX])
							continue;
						if (map[nextY][nextX] == cur) {
							queue.offer(new int[] { nextY, nextX });
							check[nextY][nextX] = true;
						}
					}
				}
				if (cur == 'W') //현재 색에 카운트 더하기
					wCnt += cnt * cnt;
				else
					bCnt += cnt * cnt;
			}
		}
		System.out.println(wCnt + " " + bCnt);
	}

}
