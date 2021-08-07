import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class M1210 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 10; i++) {
			int flag = 0;
			int[][] arr = new int[100][100];
			StringTokenizer st;
			sb.append("#").append(Integer.parseInt(br.readLine())).append(" ");
			for (int j = 0; j < 100; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int k = 0; k < 100; k++) {
					arr[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			//입력완료
			for (int j = 0; j < 100; j++)
				if (arr[99][j] == 2)
					flag = j;
			//가장 밑줄에서 당첨을 찾으면 표시
			for (int j = 99, k = flag; j >= 0; j--) {
				if (j == 0) {
					sb.append(k).append("\n");
					break;
				}//밑에서부터 시작해서 맨위에 도착할때까지
				int left = k - 1, right = k + 1;
				if (left >= 0) {//왼쪽으로 갈 수 있다면
					if (arr[j][left] == 1) {
						if (left != 0)
							while (arr[j][left - 1] == 1) {
								left = left - 1;
								if (left == 0)
									break;
							}
						k = left;
					}
				}
				else if (right <= 99) {//오른쪽으로 갈 수 있다면
					if (arr[j][right] == 1) {
						if (right != 99)
							while (arr[j][right + 1] == 1) {
								right = right + 1;
								if (right == 99)
									break;
							}
						k = right;
					}
				}
			}
		}
		System.out.println(sb.toString());
	}
}
