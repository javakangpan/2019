package work_0103;

public class Node<U> {
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
