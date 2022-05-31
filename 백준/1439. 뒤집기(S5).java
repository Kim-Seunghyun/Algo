import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1439 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String in = br.readLine();
		StringTokenizer st = new StringTokenizer(in, "0");
		int num1 = st.countTokens();
		st = new StringTokenizer(in, "1");
		int num2 = st.countTokens();
		System.out.println(Integer.min(num1, num2));
	}

}
