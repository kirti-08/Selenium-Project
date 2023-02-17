package com.excelr.ProjectOrangeHrm.Common;

public class WaitTime {
	
	public static void waitTimeInSec(int time) {
		
		try {
			Thread.sleep(time * 1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

}
