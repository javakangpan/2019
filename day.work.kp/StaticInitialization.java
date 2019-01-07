package work_0107;
/*bowl:1
bowl:2
Table()
Bowl f()1
bowl:4
bowl:5
bowl:3
Cupboard()
Bowl f()4
create new Cupboard:
bowl:3
Cupboard()
Bowl f()4
table f()1
Cupboard f()1*/

public class StaticInitialization {
	public static void main(String[] args) {
		System.out.println("create new Cupboard:");
		//create new Cupborad:
		new Cupboard();
		//bowl : 3
		//Cupboard()
		//Bowl f() 4
		table.f(1);
		//table f() 1
		cu.f(1);
		//Cupboard f() 1
	}
	static Table table = new Table();
	//bow1: 1
	//bowl: 2
	//Table()
	//Bowl f() 1
	static Cupboard cu = new Cupboard();
	//bow1 : 4
	//bow1 : 5
	//bow1 : 3
	//Cupboard()
	//Bowl f() 4
}
class Bowl {
	Bowl(int m){
		System.out.println("bowl:" + m);
	}
	void f(int m) {
		System.out.println("Bowl f()" + m);
	}
}
class Table {
	static Bowl b1 = new Bowl(1);
	Table(){
		System.out.println("Table()");
		b2.f(1);
	}
	void f(int m) {
		System.out.println("table f()" + m);
	}
	static Bowl b2 = new Bowl(2);
}
class Cupboard{
	Bowl b3 = new Bowl(3);
	static Bowl b4 = new Bowl(4);
	Cupboard(){
		System.out.println("Cupboard()");
		b4.f(4);
	}
	void f(int m) {
		System.out.println("Cupboard f()" + m);
	}
	static Bowl b5 = new Bowl(5);
}
