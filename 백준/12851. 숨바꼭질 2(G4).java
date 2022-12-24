package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class T12851 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		boolean check[] = new boolean[1000001];
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int res = Integer.MAX_VALUE;
		int sum = 0;
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { N, 0 });
		while (!queue.isEmpty()) {
			int n = queue.peek()[0];
			int cnt = queue.peek()[1];
			queue.poll();
			check[n] = true;
			if (n == K) {
				if (res > cnt) {
					res = cnt;
					sum = 1;
				} else if (res == cnt) {
					sum++;
				}
				continue;
			}
			if (n - 1 >= 0 && !check[n - 1]) {
				queue.offer(new int[] { n - 1, cnt + 1 });
			}
			if (n * 2 <= 100000 && !check[n * 2]) {
				queue.offer(new int[] { n * 2, cnt + 1 });
			}
			if (n + 1 <= 100000 && !check[n + 1]) {
				queue.offer(new int[] { n + 1, cnt + 1 });
			}
		}
		System.out.println(res);
		System.out.println(sum);
	}

}
