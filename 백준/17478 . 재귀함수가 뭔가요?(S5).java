import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.").append("\n");
		sb.append(reculsive(N, 0));
		System.out.println(sb.toString());
	}

	private static StringBuilder reculsive(int n, int cnt) {
		String s[] = { "\"재귀함수가 뭔가요?\"", "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.",
				"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.",
				"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"" };
		String t[] = { "\"재귀함수가 뭔가요?\"", "\"재귀함수는 자기 자신을 호출하는 함수라네\"", "라고 답변하였지." };
		StringBuilder sb = new StringBuilder();
		if (cnt < n) {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < cnt; j++)
					sb.append("____");
				sb.append(s[i]).append("\n");
			}
			sb.append(reculsive(n, cnt + 1));
			for (int j = 0; j < cnt; j++)
				sb.append("____");
			sb.append(t[2]).append("\n");
		}
		if (cnt == n) {	//가장마지막 실행은 3개만 
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < cnt; j++)
					sb.append("____");
				sb.append(t[i]).append("\n");
			}
		}

		return sb;
	}
}
