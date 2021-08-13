import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ15686 {
	static int N; //도시의 크기
	static int M; //뽑을 치킨집 수
	static int res; //결과값

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		res = Integer.MAX_VALUE;
		int[][] map = new int[N][N];
		List<int[]> list = new LinkedList<int[]>();
		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < N; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
				if (map[y][x] == 2)
					list.add(new int[] { y, x }); //치킨집일 경우 리스트에 추가
			}
		}
		// 입력완료
  
		int[][] combination = new int[M][2];  //뽑은 치킨집 저장할 배열
		deleteChikenHome(0, 0, list, combination, map); //치킨집 뽑기
    
		System.out.println(res);
	}

	private static void deleteChikenHome(int cnt, int start, List<int[]> list, int[][] combination, int[][] map) {
		if (cnt == M) { //M개 만큼 뽑을 경우
			// 갱신
			calChikenDistance(combination, map);
			return;
		}
		for (int i = start; i < list.size(); i++) { //전체 치킨집 탐색
			combination[cnt] = list.get(i);
			deleteChikenHome(cnt + 1, i + 1, list, combination, map);
		}
	}

	private static void calChikenDistance(int[][] combination, int[][] map) {
		int d = 0;  //모든 집의 치킨거리 저장변수
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (map[y][x] == 1) { //집 만나면
					int distance = Integer.MAX_VALUE;
					for (int i = 0; i < M; i++) {
						distance = Integer.min(distance,
								Math.abs(y - combination[i][0]) + Math.abs(x - combination[i][1]));
					} //모든 치킨집중 가장 가까운 치킨집 저장
					d += distance;  //치킨거리에 추가
				}
			}
		}
		res = Integer.min(res, d);  //결과값과 현재 뽑은 치킨집들의 치킨거리 중 작은값으로 갱신
	}

}
