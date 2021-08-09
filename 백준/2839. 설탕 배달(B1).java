import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class M2839 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.println(calSugar(N));
	}

	private static int calSugar(int n) {
		int f = fiveAndThree(n);
		int t = three(n);
		if (f == -1 && t == -1)
			return -1;  //둘 방법으롶 풀수없다면 -1 리턴
		if (f == -1 || t == -1) //둘중 하나로 풀수없다면 다른 한방법으로 리턴
			return Integer.max(f, t);
		return f < t ? f : t; //둘다 풀수있다면 더 적은연산 리턴
	}

	private static int three(int n) {
		int res = -1;
		if (n % 3 == 0)
			res = n / 3;
		return res;
	}

	private static int fiveAndThree(int n) {
		int res = -1;
		if (n % 5 == 0 && n != 0)
			return n / 5;
		if (n / 5 > 0) {
			res = n / 5;
			if (n % 5 == 1) { //1이 남으면 6으로 바꿔서 3연산
				res = res + 1;
				return res;
			} else if (n % 5 == 4) {  //4가 남으면 9로 바꿔서 3연산
				res = res + 2;
				return res;
			} else if (n % 5 == 2 && (res % 5) + 10 <= n) { //2가 남았을때 기존입력이 12보다 크면 12로 바꿔서 3연산
				res = res + 2;
				return res;
			}
			if (three(n % 5) != -1) //위 경우가 아닐때 3연산해서 더하기
				res++;
			else
				res = -1; //3연산으로 안되면 -1 리턴
		}
		return res;
	}
}
