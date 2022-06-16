import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2606 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		List<Integer> list[] = new LinkedList[N + 1];
		boolean[] check = new boolean[N + 1];
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
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
		queue.offer(1);
		check[1] = true;
		int res = 0;
		while (!queue.isEmpty()) {
			int idx = queue.poll();
			if (list[idx] == null)
				continue;
			for (int num : list[idx]) {
				if (check[num])
					continue;
				check[num] = true;
				queue.offer(num);
				res++;
			}
		}
		System.out.println(res);
	}

}
