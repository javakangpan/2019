package work_0112;

public class Ps2Adapter2 implements IPs2{

	private IUsb usb;
	Ps2Adapter2(IUsb usb){
		this.usb = usb;
	}
	@Override
	public void UsePs2() {
		// TODO Auto-generated method stub
		usb.useUsb();
		
	}

}
