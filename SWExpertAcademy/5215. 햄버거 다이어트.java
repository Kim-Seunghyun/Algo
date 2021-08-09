import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class M5215 {
	static int res;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= tc; i++) {
			res = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int maxKcal = Integer.parseInt(st.nextToken());
			int[] kcal = new int[N];
			int[] score = new int[N];
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				score[j] = Integer.parseInt(st.nextToken());
				kcal[j] = Integer.parseInt(st.nextToken());
			}
			// 입력완료
			calKcal(kcal, score, 0, 0, maxKcal, 0, N);
			sb.append("#").append(i).append(" ").append(res).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void calKcal(int[] kcal, int[] score, int cal, int s, int maxKcal, int cnt, int N) {
		if (cal == maxKcal || cnt == N) { // 칼로리 만땅 찍거나, 재료끝까지 훑으면 종료
			if (res < s)
				res = s; // 스코어 갱신
			return;
		}
		if (kcal[cnt] + cal <= maxKcal) { // 아직 칼로리 더할수있으면 더해보기
			calKcal(kcal, score, cal + kcal[cnt], s + score[cnt], maxKcal, cnt + 1, N);
		} // 안되면 다음재료
		calKcal(kcal, score, cal, s, maxKcal, cnt + 1, N);
	}

}
