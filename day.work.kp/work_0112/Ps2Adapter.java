package work_0112;

/*用于将ps2接口格式转换成为USB接口格式*/
//类适配器
public class Ps2Adapter extends Usb implements IPs2{

	@Override
	public void UsePs2() {
		useUsb();
		
	}

}
