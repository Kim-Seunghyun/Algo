import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ1463 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		makeOne(X);
	}

	private static void makeOne(int x) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(x);
		boolean[] arr = new boolean[x + 1];
		arr[x] = true;
		int num = 0;
		int cnt = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				num = queue.poll();
				if (num == 1) {
					System.out.println(cnt);
					return;
				}
				if (num % 3 == 0 && !arr[num / 3]) {
					queue.offer(num / 3);
					arr[num / 3] = true;
				}
				if (num % 2 == 0 && !arr[num / 2]) {
					queue.offer(num / 2);
					arr[num / 2] = true;
				}
				if (!arr[num - 1]) {
					queue.offer(num - 1);
					arr[num - 1] = true;
				}
			}
			cnt++;
		}
	}

}
