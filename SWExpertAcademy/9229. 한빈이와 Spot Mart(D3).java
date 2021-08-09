import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int res;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for (int i = 1; i <= tc; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			res = -1; // -1로 초기화
			for (int j = 0; j < N; j++)
				arr[j] = Integer.parseInt(st.nextToken());
			// 입력완료
			calTotalWeight(arr, 0, 0, N, M, 0);
			sb.append("#").append(i).append(" ").append(res).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void calTotalWeight(int[] arr, int cnt, int currWeight, int N, int targetWeight, int num) {
		// N개중 2개 뽑기
		if (cnt == N || currWeight == targetWeight || num == 2) { // 끝까지 도달 하거나, 무게 채웠거나, 2개 뽑은경우
			if (currWeight != 0 && res < currWeight && num == 2)
				res = currWeight; // 결과값 저장
			return;
		}
		if (currWeight + arr[cnt] <= targetWeight) { // 무게 넣을 수 있다면 넣기
			calTotalWeight(arr, cnt + 1, currWeight + arr[cnt], N, targetWeight, num + 1);
		} // 넣으면 초과시 다음 인덱스 검색
		calTotalWeight(arr, cnt + 1, currWeight, N, targetWeight, num);
	}

}
