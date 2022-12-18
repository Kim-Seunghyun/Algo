package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class T1764 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		List<String> list = new LinkedList<String>();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int cnt = 0;
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		for (int i = 0; i < N; i++) {
			String in = br.readLine();
			map.put(in, false);
		}
		for (int i = 0; i < M; i++) {
			String in = br.readLine();
			if (map.containsKey(in)) {
				list.add(in);
				cnt++;
			}
		}
		Collections.sort(list);
		for (String s : list) {
			sb.append(s).append("\n");
		}
		System.out.println(cnt);
		System.out.println(sb);
	}

}
