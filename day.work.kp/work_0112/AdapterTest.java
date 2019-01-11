package work_0112;

public class AdapterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//IPs2 ps2 = new Ps2Adapter();
		//ps2.UsePs2();
		//IPs2 ps22 = new Ps2Adapter2(new Usb());
		//ps22.UsePs2();
		
		//IUse use = new Ps2Adapter3();
		//use.ps2(ps22);
		//use.ps2(ps2);
		
		Adapter adapter = new Adapter(new Ps2Use());
		adapter.use();
		adapter = new Adapter(new UsbUse());
		adapter.use();

	}

}
