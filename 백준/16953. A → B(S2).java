import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ16953 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		Queue<long[]> queue = new LinkedList<>();
		queue.offer(new long[] { A, 0 });
		long res = -1;
		long cnt;
		long num;
		while (!queue.isEmpty()) {
			num = queue.peek()[0];
			cnt = queue.peek()[1];
			queue.poll();
			if (num == B) {
				res = cnt + 1;
				break;
			}
			if (num * 2 <= B) {
				queue.offer(new long[] { num * 2, cnt + 1 });
			}
			if (num * 10 + 1 <= B) {
				queue.offer(new long[] { num * 10 + 1, cnt + 1 });
			}
		}
		System.out.println(res);

	}
}
