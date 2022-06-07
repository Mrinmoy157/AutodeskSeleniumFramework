package practice;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.genericUtility.BaseClass;

@Listeners(com.crm.autodesk.genericUtility.ListenerImplementationClass.class)
public class ReportTest extends BaseClass{
	@Test
	public void createOrg() {
		System.out.println("passed");
	}
	@Test
	public void createContact() {
		System.out.println("fail");
		Assert.fail();
	}
	@Test
	public void createProducts() {
		throw new SkipException("Skipped");
	}

}
