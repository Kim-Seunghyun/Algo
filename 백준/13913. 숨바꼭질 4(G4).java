import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node1 {
	Node1 minus;  
	Node1 plus;
	Node1 multiply;
	Node1 parent;
	int num;

	Node1(int num) {
		this.num = num;
	}
}

public class BJ13913 {
	static boolean isChecked[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Node1 header = new Node1(N);
		isChecked = new boolean[1000001]; //0~10만 사이 수
		find(K, header);
	}

	private static void find(int k, Node1 header) {
		Queue<Node1> queue = new LinkedList<>();
		queue.offer(header);
		StringBuilder sb = new StringBuilder();
		int depth = 0;
		Node1 res;
		while (!queue.isEmpty()) {
			res = queue.poll();
			if (res.num == k) { //동생 찾으면
				while (res.parent != null) {  //부모 노드로 계속 거슬러 올라감
					sb.insert(0, res.num + " ");
					res = res.parent;
					depth++;
				}
				System.out.println(depth);
				sb.insert(0, header.num + " ");
				System.out.println(sb.toString());
				return;
			}
			add(res); //노드 추가
			if (res.multiply != null) {
				queue.offer(res.multiply);
				isChecked[res.multiply.num] = true;
			}
			if (res.minus != null) {
				queue.offer(res.minus);
				isChecked[res.minus.num] = true;
			}
			if (res.plus != null) {
				queue.offer(res.plus);
				isChecked[res.plus.num] = true;
			}

		}
	}

	private static void add(Node1 res) {
		int num = res.num;
		if (rangeCheck(num - 1)) {  //범위 밖 이거나, 이미 체크된 숫자면 노드생성 불가
			if (!isChecked[num - 1]) {  
				res.minus = new Node1(res.num - 1);
				res.minus.parent = res;
			}
		}
		if (rangeCheck(num + 1)) {
			if (!isChecked[num + 1]) {
				res.plus = new Node1(res.num + 1);
				res.plus.parent = res;
			}
		}
		if (rangeCheck(num * 2)) {
			if (!isChecked[num * 2]) {
				res.multiply = new Node1(res.num * 2);
				res.multiply.parent = res;
			}
		}
	}

	private static boolean rangeCheck(int n) {
		return n >= 0 && n <= 100000 ? true : false;
	}
}
