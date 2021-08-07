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
			for (int j = 0; j < 100; j++)
				if (arr[99][j] == 2)
					flag = j;

			for (int j = 99, k = flag; j >= 0; j--) {
				if (j == 0) {
					sb.append(k).append("\n");
					break;
				}
				boolean cross = false;
				int left = k - 1, right = k + 1;
				if (left >= 0 && cross == false) {
					if (arr[j][left] == 1) {
						if (left != 0)
							while (arr[j][left - 1] == 1) {
								left = left - 1;
								if (left == 0)
									break;
							}
						cross = true;
						k = left;
					}
				}
				if (right <= 99 && cross == false) {
					if (arr[j][right] == 1) {
						if (right != 99)
							while (arr[j][right + 1] == 1) {
								right = right + 1;
								if (right == 99)
									break;
							}
						cross = true;
						k = right;
					}
				}
				cross = false;
			}
		}
		System.out.println(sb.toString());
	}
}
