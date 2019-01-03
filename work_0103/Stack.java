package work_0103;

public class Stack<T> {
	
	private Node<T> node = new Node<T>();
	
	public void push(T temp) {
		node = new Node<T>(temp,node);
	}
	
	public T pop() {
		T result = node.item;
		if(!node.end()) {
			node = node.next;
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
