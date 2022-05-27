import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1072 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long X = Long.parseLong(st.nextToken());
		long Y = Long.parseLong(st.nextToken());
		long Z = (100 * Y / X);
		if (Z >= 99)
			System.out.println(-1);
		else {
			long min = 0;
			long max = X;
			long mid = (min + max) / 2;
			long midZ = (Y + mid) * 100 / (X + mid);
			while (mid != max && mid != min) {
				if (Z != midZ) {
					max = mid;
				} else {
					min = mid;
				}
				mid = (min + max) / 2;
				midZ = (Y + mid) * 100 / (X + mid);
			}
			System.out.println(mid + 1);
		}
  // 그냥 풀면 안되고 이분탐색
	}

}
