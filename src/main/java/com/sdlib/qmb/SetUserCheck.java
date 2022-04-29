package com.sdlib.qmb;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SetUserCheck {
	
	/** Creates a new instance of setUserCheck */
	public SetUserCheck() {
	}
		
	private String getTime() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(date);
	}	
	public String getMD5Code(String username) {	
		String code = username + this.getTime() + "MKOP{:><LSFHZ";
		KEY1 key = new KEY1();
		key.setSrc(code);
		key.setEncryptMethod(1);
		key.genKEY();
		String keycode = key.toHex();
		return keycode;
	}	
	/*public static void main(String[] args) {
		SetUserCheck set = new SetUserCheck();
		System.out.println("code=" + set.getMD5Code("8888888888"));
	}*/
	
}