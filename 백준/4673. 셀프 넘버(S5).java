
public class BJ4673 {
	static boolean[] arr;

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		arr = new boolean[10001];
		for (int i = 1; i <= 10000; i++) {
			d(i);
			if (!arr[i])
				sb.append(i).append("\n");
		}
		System.out.println(sb);
	}

	private static void d(int i) {
		int num = i;
		while (i > 0) {
			num += i % 10;
			i /= 10;
		}
		if (num > 10000)
			return;
		if (arr[num])
			return;
		arr[num] = true;
		d(num);
	}

}
