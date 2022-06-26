import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ11724 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[][] arr = new boolean[N + 1][N + 1];
		boolean[] check = new boolean[N + 1];
		List<Integer> list[] = new LinkedList[N + 1];

		int cnt = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			if (list[num1] == null) {
				list[num1] = new LinkedList<>();
			}
			if (list[num2] == null) {
				list[num2] = new LinkedList<>();
			}
			list[num1].add(num2);
			list[num2].add(num1);
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			if (!check[i]) {
				cnt++;
				queue.offer(i);
				while (!queue.isEmpty()) {
					int num = queue.poll();
					check[num] = true;
					if (list[num] == null)
						continue;
					for (int j : list[num]) {
						if (check[j])
							continue;
						queue.offer(j);
						check[j] = true;
					}
				}
			}
		}
		System.out.println(cnt);
	}

}
