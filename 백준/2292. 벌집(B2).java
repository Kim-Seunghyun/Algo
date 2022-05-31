import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2292 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int i = 1;
		int j = 6;
		int cnt = 1;
		while (true) {
			if (N > i) {
				i += j;
				j += 6;
				cnt++;
			} else
				break;
		}
		System.out.println(cnt);
	}

}
// 생각보다 
