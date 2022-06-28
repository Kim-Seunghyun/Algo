import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ11060 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N + 1];
		for (int i = 1; i <= N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Queue<int[]> queue = new LinkedList<>();
		boolean[] check = new boolean[N + 1];
		queue.offer(new int[] { 1, arr[1], 0 });
		check[1] = true;
		int idx, num, cnt;
		while (!queue.isEmpty()) {
			idx = queue.peek()[0];
			num = queue.peek()[1];
			cnt = queue.peek()[2];
			queue.poll();
			if (idx == N) {
				System.out.println(cnt);
				return;
			}
			for (int i = num; i >= 1; i--) {
				if (idx + i > N)
					continue;
				if (check[idx + i])
					continue;
				queue.offer(new int[] { idx + i, arr[idx + i], cnt + 1 });
				check[idx + i] = true;
			}
		}
		System.out.println(-1);
	}

}
