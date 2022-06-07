package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertionsTest {
	@Test
	public void demo() {
		String name1="Mrinmoy";
		String name2="Mrinmoy";
		//Assert.assertEquals(name1,name2);
		
		int a=10;
		int b=10;
		//Assert.assertEquals(a,b);
		
		byte a1=1;
		byte b1=1;
		//Assert.assertEquals(a1,b1);
		
		char c='M';
		char d='M';
		//Assert.assertEquals(c,d);
		
		float q=4.8f;
		float r=6.3f;
		//Assert.assertEquals(q,r);
		
		Object[][] objArray= new Object[2][2];
		objArray[0][0]="a";
		objArray[0][1]="b";
		
		objArray[1][0]="c";
		objArray[1][1]="d";
		
		Object[][] objArray1= new Object[2][2];
		objArray1[0][0]="a";
		objArray1[0][1]="b";
		
		objArray1[1][0]="c";
		objArray1[1][1]="d";
		
		//Assert.assertEquals(objArray,objArray1);
		
		//Assert.assertFalse(false);
		
		//Assert.assertNotEquals(name1, q);
		
		//Assert.assertNotNull(name1);
		
		//Assert.assertNotSame(objArray, objArray1);
		
		//Assert.assertNull(objArray1);
		
		//Assert.assertSame(objArray, objArray);
		
		Assert.assertTrue(true);
		
		
	}

}
