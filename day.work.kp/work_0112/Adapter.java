package work_0112;

public class Adapter{
	
	private IUse2 use;
	Adapter(IUse2 use){
		this.use = use;
	}
	public void use() {
		use.use();
	}
	
}
