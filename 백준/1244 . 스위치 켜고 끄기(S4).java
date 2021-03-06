import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int switchNum = Integer.parseInt(br.readLine());
		int[] switchCondition = new int[switchNum + 1];
		int size = 1;
		String s = br.readLine();
		st = new StringTokenizer(s);
		while (st.hasMoreTokens()) {
			switchCondition[size++] = Integer.parseInt(st.nextToken());
		}
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			s = br.readLine();
			st = new StringTokenizer(s);
			if (Integer.parseInt(st.nextToken()) == 1) {	//1은 boy
				int num = Integer.parseInt(st.nextToken());
				boyMethod(num, switchCondition);
			} else {					//2는 girl
				int num = Integer.parseInt(st.nextToken());
				girlMethod(num, switchCondition);
			}
		}
		for (int i = 1; i < switchCondition.length; i++) {
			System.out.print(switchCondition[i] + " ");
			if (i % 20 == 0)	//20개 넘어가면 줄바꿈
				System.out.println();
		}
	}

	private static void girlMethod(int num, int[] switchCondition) {
		if (switchCondition[num] == 1)
			switchCondition[num] = 0;
		else if (switchCondition[num] == 0)
			switchCondition[num] = 1;
		//현재 위치 값 부터 바꾸기
		int x = num - 1, y = num + 1;
		while (true) {
			if (x <= 0 || y >= switchCondition.length)
				break;
			//왼쪽 오른쪽 중 더 갈 수 없다면 break
			if (switchCondition[x] == switchCondition[y]) {	//좌우가 같다면 바꾸기
				if (switchCondition[x] == 0) {
					switchCondition[x] = switchCondition[y] = 1;
				} else if (switchCondition[x] == 1) {
					switchCondition[x] = switchCondition[y] = 0;
				}
			} else if (switchCondition[x] != switchCondition[y])
				break;	//다르면 break
			x--;
			y++;
		}
	}

	private static void boyMethod(int num, int[] switchCondition) {
		int i = num;	//배수 모두 바꾸기
		while (i < switchCondition.length) {
			if (switchCondition[i] == 1)
				switchCondition[i] = 0;
			else if (switchCondition[i] == 0)
				switchCondition[i] = 1;
			i = i + num;
		}
	}
}
