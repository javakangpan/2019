package work_0106;

import java.util.Arrays;

public class VampireNumbers {

	private int count;

	private long time;

	private int get4(int i) {
		return i / 1000;
	}

	private int get3(int i) {
		return (i % 1000) / 100;
	}

	private int get2(int i) {
		return (i % 100) / 10;
	}

	private int get1(int i) {
		return i % 10;
	}

	private void test(int z, int x, int y) {
		count++;
		if (z == x * y) {
			System.out.println(z + "=" + x + "*" + y);
		}

	}

	private int mod(int m, int n) {
		return m * 10 + n;
	}

	public void get() {
		long startTime = System.currentTimeMillis();
		for (int i = 1001; i < 9999; i++) {
			int a = get4(i);
			int b = get3(i);
			int c = get2(i);
			int d = get1(i);
			if (b + c + d == b || b + c + d == c || b + c + d == d) {
				continue;
			}
			test(i, mod(a, b), mod(c, d));
			test(i, mod(a, b), mod(d, c));
			test(i, mod(a, c), mod(b, d));
			test(i, mod(a, c), mod(d, b));
			test(i, mod(a, d), mod(b, c));
			test(i, mod(a, d), mod(c, b));
			test(i, mod(b, a), mod(c, d));
			test(i, mod(b, a), mod(d, c));
			test(i, mod(c, a), mod(b, d));
			test(i, mod(c, a), mod(d, b));
			test(i, mod(d, a), mod(b, c));
			test(i, mod(d, a), mod(c, b));

		}
		long endTime = System.currentTimeMillis();

		time += (endTime - startTime);
	}

	public void getOther() {
		count = 0;
		time = 0;
		long startTime = System.currentTimeMillis();
		for (int i = 10; i < 100; i++) {
			for (int j = i + 1; j < 100; j++) {
				int k = i * j;
				if (k < 1000 || k > 9999 || (k - i - j) % 9 != 0 || k % 100 == 0) {
					continue;
				}
				count++;
				int m[] = { k / 1000, k % 1000 / 100, k % 100 / 10, k % 10 };
				int n[] = { i / 10, i % 10, j / 10, j % 10 };
				Arrays.sort(m);
				Arrays.sort(n);
				if (Arrays.equals(m, n)) {
					System.out.println(k + "=" + i + "*" + j);
				}
			}
		}
		long endTime = System.currentTimeMillis();

		time += (endTime - startTime);
	}

	public static void main(String[] args) {
		VampireNumbers vampN = new VampireNumbers();
		vampN.get();
		System.out.println("共执行" + vampN.count + "次");
		System.out.println("用时" + vampN.time + "ms");
		vampN.getOther();
		System.out.println("共执行" + vampN.count + "次");
		System.out.println("用时" + vampN.time + "ms");
	}
}

