import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ10989 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] count = new int[10001];
		int max = 0;
		int num = 0;
		for (int i = 0; i < N; i++) {
			num = Integer.parseInt(br.readLine());
			count[num]++;
			if (max < num)
				max = num;
		}
		for (int i = 1; i <= max; i++) {
			while (count[i] > 0) {
				sb.append(i).append("\n");
				count[i]--;
			}
		}
		System.out.println(sb);
	}

}
