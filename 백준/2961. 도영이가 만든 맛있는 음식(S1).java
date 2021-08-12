import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2961 {
	static int res; //결과값 저장 변수
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());  //음식의 숫자
		int sour[] = new int[N];  //신맛 저장 배열
		int bitter[] = new int[N];  //쓴맛 저장 배열
		boolean isSelected[] = new boolean[N];  //부분집합 생성시 선택확인 배열
		res = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sour[i] = Integer.parseInt(st.nextToken());
			bitter[i] = Integer.parseInt(st.nextToken());
		}//입력완료
		makeFood(0, N, sour, bitter, isSelected);
		System.out.println(res);
	}

	private static void makeFood(int cnt, int n, int[] sour, int[] bitter, boolean[] isSelected) {
		if (cnt == n) {//음식의 숫자 만큼 cnt 진행시
			int sourScore = 1;  //신맛은 모든 신맛의 곱
			int bitterScore = 0;  //쓴맛은 모든 쓴맛의 합
			for (int i = 0; i < n; i++) {
				boolean flag = false; //공집합 처리용 flag변수
				if (isSelected[i]) {
					flag = true;
					sourScore *= sour[i];
					bitterScore += bitter[i];
				}
				if (flag) { //공집합이 아니라면
					int score = Math.abs(sourScore - bitterScore);  //신맛과 쓴맛의 차이 계산 후
					if (res > score)  //갱신
						res = score;
				}
			}
			return;
		}
 
		isSelected[cnt] = true;
		makeFood(cnt + 1, n, sour, bitter, isSelected);

		isSelected[cnt] = false;
		makeFood(cnt + 1, n, sour, bitter, isSelected);
	}

}
