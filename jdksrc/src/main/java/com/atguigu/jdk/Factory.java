package com.atguigu.jdk;

import java.util.Calendar;

public class Factory {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
	    System.out.println("��:" + cal.get(Calendar.YEAR));
	    System.out.println("��:" + (cal.get(Calendar.MONTH) + 1));       
	    System.out.println("��:" + cal.get(Calendar.DAY_OF_MONTH));
	    System.out.println("ʱ:" + cal.get(Calendar.HOUR_OF_DAY));
	    System.out.println("��:" + cal.get(Calendar.MINUTE));
	    System.out.println("��:" + cal.get(Calendar.SECOND));

	    
	}

}


