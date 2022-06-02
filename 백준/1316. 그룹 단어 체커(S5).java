import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1316 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean check[];
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			String in = br.readLine();
			int len = in.length();
			check = new boolean[27];
			boolean flag = true;
			for (int j = 0; j < len; j++) {
				char c = in.charAt(j);
				if (check[c - 'a'])
					flag = false;
				for (int k = j + 1; k < len; k++) {
					if (in.charAt(k) == c) {
						continue;
					} else {
						j = k - 1;
						int num = c - 'a';
						if (check[num])
							flag = false;
						else {
							check[num] = true;
						}
						break;
					}
				}

			}
			if (flag)
				cnt++;
		}
		System.out.println(cnt);
	}

}
