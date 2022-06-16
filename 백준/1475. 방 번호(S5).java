import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1475 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String in = br.readLine();
		int len = in.length();
		int[] arr = new int[10];
		int max = 0;
		for (int i = 0; i < len; i++) {
			int idx = in.charAt(i) - '0';
			arr[idx]++;
			if (max < arr[idx])
				max = arr[idx];
		}
		if (arr[6] - max == 0 || arr[9] - max == 0) {
			int num = arr[6] - max < arr[9] - max ? arr[6] - max : arr[9] - max;
			num = Math.abs(num) / 2;
			max -= num;
		}
		for (int i = 0; i < 9; i++) {
			if (i == 6)
				continue;
			if (arr[i] > max)
				max = arr[i];
		}
		System.out.println(max);
	}

}
