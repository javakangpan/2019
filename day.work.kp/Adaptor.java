package work_0106;

import java.util.Iterator;

public class Adaptor extends Fibonacci implements Iterable<Integer> {
	
	private int n;
	
	Adaptor(int n){
		this.n = n;
	}

	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {

			@Override
			public boolean hasNext() {
				
				return n > 0;
			}

			@Override
			public Integer next() {
				n--;
				return Adaptor.this.next();
			}};
	}
	
	public static void main(String[] args) {
		for(int i : new Adaptor(5)) {
			System.out.print(i + " ");
		}
	}

}
