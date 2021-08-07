import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class M1225 {

	public static void main(String[] args) throws IOException {
		Queue<Integer> queue = new LinkedList<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 10; i++) {
			sb.append("#").append(i).append(" ");
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 8; j++) {
				queue.add(Integer.parseInt(st.nextToken()));
			}
			//입력완료
			int cnt = 1;
			while (true) {
				int tmp = queue.poll() - cnt;
				if (tmp <= 0) {	//뽑은 수가 0이하가 된다면 break
					tmp = 0;
					queue.add(tmp);
					break;
				}
				queue.add(tmp);
				cnt++;
				if (cnt >= 6)	//차감시키는 수가 6이상되면 다시 1로 초기화
					cnt = cnt % 5;
			}
			while (!queue.isEmpty()) {
				sb.append(queue.poll()).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
