package practice;

import org.testng.annotations.Test;

public class Sample {
	@Test(groups="smokeTest")
	public void Sample1() {
		System.out.println("Sample1 executed");
	}
	
	@Test(groups="sanityTest")
	public void Sample2() {
		System.out.println("Sample1 executed");
	}
	
	@Test(groups="smokeTest")
	public void Sample3() {
		System.out.println("Sample1 executed");
	}
	
	@Test(groups="sanityTest")
	public void Sample4() {
		System.out.println("Sample1 executed");
	}

}
