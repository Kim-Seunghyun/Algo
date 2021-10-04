import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1753 {

	static class Node {
		List<int[]> list;

		Node() {
			list = new LinkedList<>();
		}

		void add(int v, int w) {
			list.add(new int[] { v, w });
		}
	}

	static int V, E, start;
	static int[] cost;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Node[] nodes = new Node[V + 1];
		for (int i = 1; i <= V; i++)
			nodes[i] = new Node();
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			nodes[u].add(v, w);
		}
		cost = new int[V + 1];
		bfs(nodes);
		for (int i = 1; i <= V; i++) {
			if (cost[i] == Integer.MAX_VALUE)
				sb.append("INF").append("\n");
			else
				sb.append(cost[i]).append("\n");
		}
		System.out.println(sb);
	}

	private static void bfs(Node[] nodes) {
		for (int i = 1; i <= V; i++)
			cost[i] = Integer.MAX_VALUE;
		cost[start] = 0;
		boolean[] visited = new boolean[V + 1];
		PriorityQueue<int[]> pQueue = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {

				return o1[1] - o2[1];
			}

		});
		pQueue.offer(new int[] { start, 0 });
		while (!pQueue.isEmpty()) {
			int[] cur = pQueue.poll();
			if (visited[cur[0]])
				continue;
			visited[cur[0]] = true;
			for (int[] num : nodes[cur[0]].list) {
				int next = num[0];
				int weight = num[1];
				if (cost[next] > cur[1] + weight) {
					pQueue.offer(new int[] { next, cur[1] + weight });
					cost[next] = cur[1] + weight;
				}
			}
		}
	}

}
