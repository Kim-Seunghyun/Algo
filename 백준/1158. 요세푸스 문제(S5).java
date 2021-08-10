import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ1158 {

	public static void main(String[] args) throws Exception {
		LinkedList<Integer> list = new LinkedList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		sb.append("<");
		add(list, N);
    //입력완료
		int cnt = 0;
		while (!list.isEmpty()) {
			if (list.size() == 1) { //마지막 인덱스 처리
				sb.append(list.poll());
				break;
			}
			cnt = cnt + K;  //인덱스 갱신
			if (cnt > list.size()) {
				while (cnt > list.size())
					cnt -= list.size();
			}
			sb.append(list.get(cnt - 1)).append(", ");  //해당 인덱스 빌더에 넣고 리스트에서 제거
			list.remove(cnt - 1);
			cnt--;  
		}
		sb.append(">");
		System.out.println(sb.toString());
	}

	private static void add(LinkedList<Integer> list, int n) {
		for (int i = 1; i <= n; i++)
			list.add(i);
	}

}
