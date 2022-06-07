import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ11866 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int cur = 0;
		List<Integer> list = new LinkedList<Integer>();
		sb.append("<");
		for (int i = 0; i < N; i++) {
			list.add(i + 1);
		}
		while (list.size() > 0) {
			cur += K - 1;
			while (cur >= list.size())
				cur -= list.size();
			sb.append(list.get(cur));
			list.remove(cur);
			if (list.size() != 0) {
				sb.append(", ");
			} else {
				sb.append(">");
			}
		}
		System.out.println(sb);
	}

}
