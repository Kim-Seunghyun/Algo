import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			int tc = Integer.parseInt(br.readLine());
			sb.append("#").append(i).append(" ");
			char[][] farm = new char[tc][tc];
			for (int j = 0; j < tc; j++) {
				farm[j] = br.readLine().toCharArray();
			}
			//입력완료
			int y = 0;
			int x = (tc - 1) / 2;
			int res = 0;
			boolean flag = false;
			for (int k = 0; k < tc; k++) {
				if (flag == false) {	//농장의 가로크기 도달전
					for (int l = x - k; l <= x + k; l++) {
						res = res + farm[k][l] - '0';	//늘려가기
					}
					if (k == x)	//농장의 가로크기 도달
						flag = true;
				} else if (flag == true) {
					for (int l = x - (tc - k - 1); l <= x + (tc - k - 1); l++) {
						res = res + farm[k][l] - '0';	//줄여가기
					}
				}
			}
			sb.append(res).append("\n");
		}
		System.out.println(sb.toString());
	}
}
