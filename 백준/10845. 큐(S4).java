import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ10845 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		List<Integer> list = new LinkedList<Integer>();
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			String com = st.nextToken();
			if (com.equals("push")) {
				list.add(Integer.parseInt(st.nextToken()));
			} else if (com.equals("front")) {
				if (list.size() == 0) {
					sb.append(-1).append("\n");
					continue;
				}
				sb.append(list.get(0)).append("\n");
			} else if (com.equals("back")) {
				if (list.size() == 0) {
					sb.append(-1).append("\n");
					continue;
				}
				sb.append(list.get(list.size() - 1)).append("\n");
			} else if (com.equals("pop")) {
				if (list.size() == 0) {
					sb.append(-1).append("\n");
					continue;
				}
				int num = list.get(0);
				list.remove(0);
				sb.append(num).append("\n");
			} else if (com.equals("size")) {
				sb.append(list.size()).append("\n");
			} else {
				if (list.size() == 0) {
					sb.append(1).append("\n");
				} else
					sb.append(0).append("\n");
			}
		}
		System.out.println(sb);
	}

}
