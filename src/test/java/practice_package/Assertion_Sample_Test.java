package practice_package;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

import org.testng.Assert;
import org.testng.Assert.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertion_Sample_Test
{
	@Test
	public void sample()
	{
		System.out.println("--testscript 1--");
		System.out.println("--testscript 2--");
		assertEquals("A", "B");
		System.out.println("--testscript 3--");
		System.out.println("--testscript 4--");
		
	}
	
	@Test
	public void sample_1()
	{
		System.out.println("--testscript 5--");
		System.out.println("--testscript 6--");
		assertNotEquals("A", "B");
		System.out.println("--testscript 7--");
	}
	
	@Test
	public void sample_3()
	{
		String a=null;
		assertNull(a);
		System.out.println("--testscript 8--");
	}
	@Test
	public void sample_5()
	{
		System.out.println("--testscript11--");
		SoftAssert s=new SoftAssert();
		s.assertEquals("A", "B");
		//s.assertAll();
		System.out.println("testscrip-12");
	s.assertAll();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
