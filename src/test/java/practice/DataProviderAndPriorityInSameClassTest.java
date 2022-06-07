package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DataProviderAndPriorityInSameClassTest {
	@Test(priority=2)
	public void demo() {
		System.out.println("demo method");
	}
	@Test(dependsOnMethods="demo",priority=4)
	public void mrin() {
		System.out.println("mrin method");
	}
	@Test(priority=3,dependsOnMethods="mrin")
	public void sample() {
		System.out.println("sample method");
	}

}
