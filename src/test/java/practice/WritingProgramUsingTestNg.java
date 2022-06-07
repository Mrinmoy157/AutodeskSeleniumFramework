package practice;

import org.testng.annotations.Test;

public class WritingProgramUsingTestNg {
	@Test(priority=1)
	public void A() {
		System.out.println("Hi");
	}
	@Test(priority=2)
	public void B() {
		System.out.println("Hello");
	}
	@Test(priority=3)
	public void C() {
		System.out.println("Hey");
	}
}
