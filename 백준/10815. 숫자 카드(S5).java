import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ10815 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int in = Integer.parseInt(st.nextToken());
			map.put(in, true);
		}
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int in = Integer.parseInt(st.nextToken());
			if (map.containsKey(in))
				sb.append(1).append(" ");
			else
				sb.append(0).append(" ");
		}
		System.out.print(sb);
	}

}
