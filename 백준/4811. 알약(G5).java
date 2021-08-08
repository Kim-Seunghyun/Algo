import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class BJ4811 {
	static double[][] memo;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = 0;
		memo = new double[31][31];
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;//0이 나오면 입력종료
			BigDecimal bd = new BigDecimal(Alyac(N, 0));//지수표기법 제거
			sb.append(bd.toString()).append("\n");
		}
		System.out.println(sb.toString());
	}

	public static double Alyac(int W, int H) {
		double w = 0, h = 0;
		if (W == 1 && H == 0)
			return memo[1][0] = 1;
		if (W == 0 && H == 1)
			return memo[0][1] = 1;
		if (W == 2 && H == 0)
			return memo[2][0] = 2;
		if (memo[W][H] != 0) {//기존 메모해놓은 값이 있다면 그거 보여줌
			return memo[W][H];
		}
		if (W > 0)
			w = Alyac(W - 1, H + 1);
		if (H > 0)
			h = Alyac(W, H - 1);
		return memo[W][H] = w + h; //메모 해둔거 없으면 쪼개서 메모 후 저장하면서 리턴
	}
}
