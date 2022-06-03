import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10250 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int cnt = 1;
			int room = 1;
			while (N > 0) {
				if (N > H) {
					N -= H;
					room++;
				} else {
					cnt = N;
					N = 0;
				}
				if (cnt > H) {
					cnt = 1;
					room++;
				}
			}

			String num;
			if (room < 10)
				num = '0' + ("" + room);
			else
				num = "" + room;
			sb.append(cnt).append(num).append("\n");
		}
		System.out.println(sb);
	}

}
