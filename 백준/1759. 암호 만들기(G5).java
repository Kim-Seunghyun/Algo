import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1759 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int L = Integer.parseInt(st.nextToken()); 
		int C = Integer.parseInt(st.nextToken());
		String s = br.readLine();
		char[] arr = new char[C]; //문자 저장 배열
		char[] res = new char[L]; //결과값 저장 배열
		boolean[] isSelected = new boolean[C];  //중복 방지 배열
		for (int i = 0; i < C; i++) {
			arr[i] = s.charAt(2 * i);
		}
		sort(arr);
		findPW(arr, 0, 0, L, C, res, isSelected);
	}

	private static void findPW(char[] arr, int cnt, int start, int L, int C, char[] res, boolean[] isSelected) {
		if (cnt == L) {
			boolean PW = false; //모음이 사용되는지 확인해야됨
			int consonantCnt = 0; //최소 2개의 자음을 사용해야함
			for (int i = 0; i < L; i++) {
				if (res[i] == 'a' || res[i] == 'e' || res[i] == 'i' || res[i] == 'o' || res[i] == 'u')  //결과배열에서 모음 나오면 PW = true
					PW = true;
				else
					consonantCnt++; //자음 나오면 자음 카운트 수 증가
			}
			if (PW && consonantCnt >= 2) {  //모음도 나왔고, 자음도 2개이상 썼으면 출력
				System.out.println(res);
			}
			return;
		}
		for (int i = start; i < C; i++) {
			if (isSelected[i])
				continue;
			res[cnt] = arr[i];
			isSelected[i] = true;
			findPW(arr, cnt + 1, i, L, C, res, isSelected);
			isSelected[i] = false;
		}
	}

	private static void sort(char[] arr) {  //문제 조건이 타이트하지 않으니 그냥 버블
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					char tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
	}
}
