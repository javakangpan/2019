package work_0125;

import java.util.logging.Logger;

public class DynamicSetKeyAndValue {
	
	private static Logger logger = Logger.getLogger("DynamicFields");
	
	static class DynamicSetKeyAndValueException extends Exception {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
	}
	
	private Object[][] fields;
	
	public DynamicSetKeyAndValue(int initSize) {
		
		fields = new Object[initSize][2];
		
		for(int i = 0; i < initSize; i++) {
			fields[i] = new Object[]{null,null};
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("key :" + "value");
		sb.append("\n");
		sb.append("---------------------------------------");
		sb.append("\n");
		for(Object[] obj : fields) {
			sb.append(obj[0]);
			sb.append(": " + obj[1]);
			sb.append("\n");
		}
		return new String(sb);
	}
	
	private int hasKey(String key) {
		for(int i = 0; i < fields.length;i++) {
			if(key.equals(fields[i][0])) {
				logger.info("i： " + i);
				return i;
			}
		}
		return -1;
	}
	
	private int checkIndex(String key) throws NoSuchFieldException {
		int index = hasKey(key);
		if(-1 == index) {
			throw new NoSuchFieldException();
		}
		return index;
	}
	
	private void setKeyAndValue(String key,Object value) throws DynamicSetKeyAndValueException {
		
		if(null == value) {
			DynamicSetKeyAndValueException exception = new DynamicSetKeyAndValueException();
			exception.initCause(new NullPointerException("value is null"));
			throw exception;
		}
		
		int index = hasKey(key);
		
		if(-1 == index) {
			index = setKey(key);
		}
		
		try {
			getValue(key);
		} catch (NoSuchFieldException e) {
			throw new RuntimeException();
		}
		fields[index][1] = value;
	}
	
	private Object getValue(String key) throws NoSuchFieldException {
		return fields[checkIndex(key)][1];
	}

	private int setKey(String key) {
		for(int i = 0; i < fields.length; i++) {
			if(null == fields[i][0]) {
				fields[i][0] = key;
				return i;
			}
		}
			
		Object[][] temp = new Object[fields.length + 1][2];
		for(int i = 0; i < fields.length; i++) {
			temp[i] = fields[i];
		}
		
		temp[fields.length] = new Object[] {null,null};
		fields = temp;
		return setKey(key);
	}

	public static void main(String[] args) {
		DynamicSetKeyAndValue dynamicFields = new DynamicSetKeyAndValue(3);
		try {
			dynamicFields.setKeyAndValue("姓名", "康盼");
			dynamicFields.setKeyAndValue("性别", "男");
			dynamicFields.setKeyAndValue("年龄", "27岁");
			dynamicFields.setKeyAndValue("身高", "170米");
			System.out.println(dynamicFields);
			System.out.println(dynamicFields.getValue("姓名"));
			dynamicFields.setKeyAndValue("测试value值为空报错", null);
		} catch (NoSuchFieldException  e) {
			e.printStackTrace(System.out);
		} catch(DynamicSetKeyAndValueException e) {
			e.printStackTrace(System.out);
		}
	}
	
}
