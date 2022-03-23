package com.crm.vtiger.software.testscripts;

import org.testng.annotations.Test;

public class GetParametersTest {
	@Test
	public void getRuntimeData() {
		
		String browsername = System.getProperty("browser");
		System.out.println(browsername);
		
		String urlname = System.getProperty("url");
		System.out.println(urlname);
		
		String username = System.getProperty("username");
		System.out.println(username);
		
		String password = System.getProperty("password");
		System.out.println(password);
	
		
		
		
		
		
	}

}
