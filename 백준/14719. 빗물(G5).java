package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class T14719 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[] num = new int[W];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		int res = 0;
		for (int i = W - 1; i >= 0; i--) {
			int h = num[i];
			if (h == 0)
				continue;
			int n = 1;
			int sum = 0;
			int breakNum = 0;
			boolean flag = false;
			while (i - n >= 0) {
				int tmp = num[i - n];
				if (tmp >= h) {
					flag = true;
					breakNum = i - n;
					break;
				} else if (i - n == 0) {
					n = 0;
					h--;
					sum = 0;
					if (h == 0)
						break;
				} else {
					sum += (h - num[i - n]);
				}
				n++;
			}
			if (flag) {
				res += sum;
				i = breakNum + 1;
			}
		}
		System.out.println(res);
	}

}
