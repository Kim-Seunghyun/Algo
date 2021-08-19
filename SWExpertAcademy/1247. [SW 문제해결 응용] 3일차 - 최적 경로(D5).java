import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class M1247 {
	static int res; //결과값 저장
	static boolean[] visited; //방문한 인덱스인지 체크

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= TC; t++) {
			sb.append("#").append(t).append(" ");
			int N = Integer.parseInt(br.readLine());
			int[][] customer = new int[N][2]; // 0번째가 y 1번째가 x
			int[] company = new int[2];
			int[] home = new int[2];
			StringTokenizer st = new StringTokenizer(br.readLine());
			company[1] = Integer.parseInt(st.nextToken());
			company[0] = Integer.parseInt(st.nextToken());
			home[1] = Integer.parseInt(st.nextToken());
			home[0] = Integer.parseInt(st.nextToken());
			for (int i = 0; i < N; i++) {
				customer[i][1] = Integer.parseInt(st.nextToken());
				customer[i][0] = Integer.parseInt(st.nextToken());
			}
      //입력완료
      
			visited = new boolean[N];
			res = Integer.MAX_VALUE;  //Integer 최대값으로 결과값 초기화
			findMiniPath(customer, company, home[0], home[1], 0, 0);
			sb.append(res).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void findMiniPath(int[][] customer, int[] company, int y, int x, int score, int cnt) {
		if (score > res)  //집 마다 방문하며 거리 계산 도중 전체결과값 보다 커진다면 바로 리턴
			return;
		if (cnt == customer.length) { //모든 손님집을 방문 했다면
			score += Math.abs(y - company[0]) + Math.abs(x - company[1]); //마지막 손님집에서 회사까지 거리 구한 후
			res = Integer.min(res, score);  //결과 갱신
			return;
		}
		for (int i = 0; i < customer.length; i++) {
			if (visited[i]) //이미 방문한 집이라면 건너뛰기
				continue;
			visited[i] = true;  //방문 하지 않았다면 방문 처리 후
			int newY = customer[i][0];
			int newX = customer[i][1];
			int s = Math.abs(y - newY) + Math.abs(x - newX);  //현재 좌표에서 거리 구한 후
			findMiniPath(customer, company, newY, newX, score + s, cnt + 1);  //다음집 탐색
			visited[i] = false; //모든 집 탐색을 위해 res 나오면 방문 풀어주기
		}
	}
}
