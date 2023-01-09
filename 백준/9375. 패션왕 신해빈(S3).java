package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class T9375 {
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		Map<String, Integer> map;
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new HashMap<String, Integer>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				String key = st.nextToken();
				if (!map.containsKey(key)) {
					map.put(key, 1);
				} else {
					map.put(key, map.get(key) + 1);
				}
			}
			int sum = 1;
			for (int cnt : map.values()) {
				sum *= (cnt + 1);
			}
			sum -= 1;
			sb.append(sum).append("\n");
		}
		System.out.println(sb.toString());
	}

}
