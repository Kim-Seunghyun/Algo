import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ17135 {

	static int N; //y크기
	static int M; //x크기
	static int D; //사정거리
	static int res; //결과값

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		res = Integer.MIN_VALUE;
		int[][] map = new int[N + 1][M];  //map[N]행에는 궁수가 위치
		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < M; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		// 입력 완료

		// 0~M-1 사이에서 3개 순열 뽑기
		int[] archerPosition = new int[3];
		setArcher(0, 0, map, archerPosition);
		// 뽑고 나서 시뮬레이션 돌려보기
		System.out.println(res);
	}

	private static void setArcher(int cnt, int start, int[][] map, int[] archerPosition) {
		if (cnt == 3) {
			// 시뮬레이션
			int[][] cloneMap = new int[N][M];
			int monsterCount = 0;
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < M; x++) {
					cloneMap[y][x] = map[y][x]; //기존맵 복사해서 사용
					if (cloneMap[y][x] == 1)
						monsterCount++;
				}
			}
			simulate(cloneMap, archerPosition, monsterCount);
			return;
		}
		for (int i = start; i < M; i++) { //순열 뽑기
			archerPosition[cnt] = i;
			setArcher(cnt + 1, i + 1, map, archerPosition);
		}
	}

	private static void simulate(int[][] cloneMap, int[] archerPosition, int count) {
//		System.out.println(Arrays.toString(archerPosition));
		boolean simulationEnd = false;  //시뮬레이션 종료 조건(몬스터 수 - 0)
		int num = 0;
		int[][] dir = { { 0, -1 }, { -1, 0 }, { 0, 1 } }; // 좌 상 우
		while (!simulationEnd) {
			int cnt = 0;
			while (cnt < 3) {
				// 화살 쏘기
				boolean[][] isVisited = new boolean[N][M];
				// 거리가 가까운 순으로 탐색 거리가 가까운 적이 여럿이라면 x가 작은 순부터
				Queue<int[]> enemyQueue = new LinkedList<>();
				enemyQueue.offer(new int[] { N - 1, archerPosition[cnt] }); // 궁수 바로 위칸부터 탐색
				isVisited[N - 1][archerPosition[cnt]] = true; //바로 위칸은 방문함으로 처리
				int curX = archerPosition[cnt];
				int curY = N; //궁수의 x, y좌표 설정
				while (!enemyQueue.isEmpty()) { //사정거리 안에서 적이 존재할 수 있는 위치를 모두 볼 때까지 실행
					int tmp[] = enemyQueue.poll();  
					int y = tmp[0];
					int x = tmp[1]; //현재 탐색중인 x, y좌표
					if (cloneMap[y][x] >= 1) {
						cloneMap[y][x]++; //본 곳에 몬스터가 있다면 화살 쏘기
						break;
					}
					for (int i = 0; i < 3; i++) { //없으면 다음 사정거리확인
						int nextY = y + dir[i][0];
						int nextX = x + dir[i][1];
						if (nextX < 0 || nextY < 0 || nextX >= M) //본 곳이 맵 밖이면 큐에 넣지 않음
							continue;
						if (Math.abs(curY - nextY) + Math.abs(curX - nextX) > D) {  //본 곳이 사정거리 밖이면 큐에 넣지 않음
							continue;
						}
						if (!isVisited[nextY][nextX]) { //이미 본곳이 아니라면 해당 위치 큐에 넣고 방문처리
							enemyQueue.offer(new int[] { nextY, nextX });
							isVisited[nextY][nextX] = true;
						}
					}
				}
				cnt++;  //다음 궁수 입장~
			}
//			System.out.println("==================================================");
//			System.out.println();
//			for (int y = 0; y < N; y++) {
//				for (int x = 0; x < M; x++) {
//					System.out.print(cloneMap[y][x] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println("==================================================");
      
			// 죽은 적 카운팅 하고 num에 추가 후 밑으로 내리기
			for (int x = 0; x < M; x++) {
				if (cloneMap[N - 1][x] > 1) {
					cloneMap[N - 1][x] = 0;
					count--;
					num++;
				} else if (cloneMap[N - 1][x] == 1) {
					cloneMap[N - 1][x] = 0;
					count--;
				}
        
			} // 몬스터가 성으로 침입
			for (int y = N - 1; y > 0; y--) {
				for (int x = 0; x < M; x++) {
					cloneMap[y][x] = cloneMap[y - 1][x];
					if (cloneMap[y][x] > 1) {
						cloneMap[y][x] = 0;
						count--;
						num++;
					}
				}
        
			} // 오다가 죽은 경우
      
			for (int x = 0; x < M; x++)
				cloneMap[0][x] = 0;
			// 제일 윗칸 처리

//			System.out.println("==================================================");
//			System.out.println();
//			for (int y = 0; y < N; y++) {
//				for (int x = 0; x < M; x++) {
//					System.out.print(cloneMap[y][x] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println("==================================================");

			if (count == 0) //몬스터가 모두 죽었다면 시뮬레이션 종료
				simulationEnd = true;
		}
//		System.out.println(num);
		res = Integer.max(res, num);  //이번 시뮬레이션의 결과값과 전체 점수중 큰값으로 갱신
	}

}
