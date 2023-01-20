package practice_package;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.onlinebanking.genericutilities.BaseClass;

public class Sample_Retry_Test  
{
	@Test(retryAnalyzer = com.onlinebanking.genericutilities.RetryImplementationClass.class)
	public void sampleTest()
	{
		Assert.assertEquals("A", "B");
		
		
	}

}

