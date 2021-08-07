import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= T; i++) {
			sb.append("#").append(i).append(" ");
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			//N이 짝수라면 같게 나뉘고 홀수면 앞의 카드뭉치가 1개 더 많아야함
			String[] s1 = new String[(N + 1) / 2];
			String[] s2 = new String[N / 2];
			for (int j = 0; j < s1.length; j++) {
				s1[j] = st.nextToken();
			}
			for (int j = 0; j < s2.length; j++)
				s2[j] = st.nextToken();
			//카드 나누기 완료
			int cnt = 0;
			while (cnt < s1.length || cnt < s2.length) {
				if (cnt < s1.length)
					sb.append(s1[cnt]).append(" ");
				if (cnt < s2.length)
					sb.append(s2[cnt]).append(" ");
				cnt++;
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
