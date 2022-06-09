import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1966 {
	static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int len = 0;
		int res;
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			len = Integer.parseInt(st.nextToken());
			cnt = Integer.parseInt(st.nextToken());
			res = 1;
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < len; j++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			while (!queue.isEmpty()) {
				sortBySearchMax(queue);
				if (cnt == 0) {
					sb.append(res).append("\n");
					queue.clear();
					break;
				}
				res++;
				cnt--;
				queue.poll();
			}
		}

		System.out.println(sb);
	}

	private static void sortBySearchMax(Queue<Integer> queue) {
		int max = 0;
		int flag = 0;
		int idx = 0;
		for (int num : queue) {
			if (num > max) {
				max = num;
				flag = idx;
			}
			idx++;
		}
		for (int i = 0; i < flag; i++) {
			max = queue.poll();
			queue.add(max);
		}
		if (flag > cnt) {
			cnt = queue.size() - (flag - cnt);
		} else {
			cnt -= flag;
		}
	}

}
