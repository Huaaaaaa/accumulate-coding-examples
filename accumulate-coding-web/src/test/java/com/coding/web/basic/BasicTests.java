package com.coding.web.basic;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BasicTests {

//	@Test
	void contextLoads() {
	}


	@Test
	public void testToBin(){
		int originVal = 138;
		String binData = Integer.toBinaryString(originVal);
		String binStrData = new StringBuffer(binData).reverse().toString();
		System.out.println("binData="+binData+"\r\nbinStrData="+binStrData);
	}

}
