package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class T1182 {
	static boolean[] selected;
	static int res, N, S;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		selected = new boolean[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		subset(0, 0, false);
		System.out.println(res);
	}

	private static void subset(int cnt, int sum, boolean flag) {
		if (cnt == N) {
			if (sum == S) {
				if (!flag)  // 공집합 
					return;
				res++;
			}
			return;
		}

		selected[cnt] = true;
		subset(cnt + 1, sum + arr[cnt], flag | true);
		selected[cnt] = false;
		subset(cnt + 1, sum, flag | false);
	}

}
