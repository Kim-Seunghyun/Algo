import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ15558 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		char[][] arr = new char[2][N];
		for (int i = 0; i < 2; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[][] check = new boolean[2][N];
		queue.offer(new int[] { 0, 0, 0 });
		check[0][0] = true;
		while (!queue.isEmpty()) {
			int idx = queue.peek()[0];
			int i = queue.peek()[1];
			int cnt = queue.peek()[2];
			queue.poll();
			if (i > 0 && cnt < (i - 1) && !check[idx][i - 1] && arr[idx][i - 1] == '1') {
				queue.offer(new int[] { idx, i - 1, cnt + 1 });
				check[idx][i - 1] = true;
			}
			if (i + 1 < N && !check[idx][i + 1] && arr[idx][i + 1] == '1') {
				queue.offer(new int[] { idx, i + 1, cnt + 1 });
				check[idx][i + 1] = true;
			}
			int cIdx = (idx + 1) % 2;
			if (i + K < N && !check[cIdx][i + K] && arr[cIdx][i + K] == '1') {
				queue.offer(new int[] { cIdx, i + K, cnt + 1 });
				check[cIdx][i + K] = true;
			}
			if (i + 1 >= N || i + K >= N) {
				System.out.println(1);
				return;
			}
		}
		System.out.println(0);
	}

}
