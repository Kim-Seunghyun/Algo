import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1260 {
	static class Node {
		// 정점
		List<Integer> list;

		public Node() {
			this.list = new LinkedList<>();
		}

		void add(int num) {
			int size = this.list.size();
			for (int i = 0; i < size; i++) {
				if (num < list.get(i)) {
					list.add(i, num);
					return;
				}
			}
			list.add(num);
		}
	}

	static boolean[] check;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		Node[] nodes = new Node[V + 1];
		for (int i = 1; i <= V; i++)
			nodes[i] = new Node();
		// 정점 번호는 1~N 수
		for (int i = 1; i <= E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			nodes[s].add(d);
			nodes[d].add(s);
		}
		check = new boolean[V + 1];
		sb = new StringBuilder();
		dfs(nodes, start);
		System.out.println(sb);
		sb = new StringBuilder();
		check = new boolean[V + 1];
		bfs(nodes, start);
		System.out.println(sb);
	}

	private static void bfs(Node[] nodes, int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		check[start] = true;
		while (!queue.isEmpty()) {
			int num = queue.poll();
			sb.append(num).append(" ");
			for (int next : nodes[num].list) {
				if (check[next])
					continue;
				queue.offer(next);
				check[next] = true;
			}
		}
	}

	private static void dfs(Node[] nodes, int start) {
		if (check[start])
			return;
		check[start] = true;
		sb.append(start).append(" ");
		for (int num : nodes[start].list) {
			dfs(nodes, num);
		}
	}

}
