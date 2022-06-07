package practice;

import org.testng.annotations.Test;

public class Demo {
	@Test(groups="smokeTest")
	public void Demo1() {
		System.out.println("Demo1 executed");
	}
	
	@Test(groups="sanityTest")
	public void Demo2() {
		System.out.println("Demo1 executed");
	}
	
	@Test(groups="smokeTest")
	public void Demo3() {
		System.out.println("Demo1 executed");
	}
	
	@Test(groups="sanityTest")
	public void Demo4() {
		System.out.println("Demo1 executed");
	}
	
}
