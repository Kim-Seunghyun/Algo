import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1049 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int bundle = Integer.MAX_VALUE;
		int individual = Integer.MAX_VALUE;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int bun = Integer.parseInt(st.nextToken());
			int ind = Integer.parseInt(st.nextToken());
			if (bundle > bun)
				bundle = bun;
			if (individual > ind)
				individual = ind;
		}
		int res = 0;
		while (N > 0) {
			if (N >= 6) {
				int num = Integer.min(bundle, 6 * individual);
				res += num;
				N -= 6;
			} else {
				int num = Integer.min(bundle, N * individual);
				res += num;
				N -= N;
			}
		}
		System.out.println(res);
	}

}
