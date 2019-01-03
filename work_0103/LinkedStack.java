package work_0103;

public class LinkedStack<T> {
	private static class Node<U> {
		U item;
		Node<U> next;
		Node(){
			item = null;
			next = null;
		}
		Node(U item,Node<U> next){
			this.item = item;
			this.next = next;
		}
		boolean end() {
			return null == item && null == next;
		}		
	}
	private Node<T> top = new Node<T>();
	
	public void push(T item) {
		top = new Node<T>(item,top);
	}
	public T pop() {
		T result = top.item;
		if(!top.end()) {
			top = top.next;
		}
		return result;
	}
	
	public static void main(String[] args) {
		LinkedStack<String> ls = new LinkedStack<String>();
		for(String s : "hello! pan kang".split(" ")) {
			ls.push(s);
		}
		String str;
		while((str=ls.pop())!=null) {
			System.out.print(str + " ");
		}
	}
}
