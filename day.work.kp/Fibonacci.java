package work_0106;

public class Fibonacci implements Generator<Integer> {
	
	private int count = 0;

	private int f(int n) {
		if(n < 2) {
			return 1;
		}
		return f(n-2) + f(n-1);
	}

	@Override
	public Integer next() {
		return f(count++);
	}
	
	public static void main(String[] args) {
		Fibonacci fi = new Fibonacci();
		for(int i = 0; i < 5; i++) {
			System.out.print(fi.next()+" ");
		}
	}
}
