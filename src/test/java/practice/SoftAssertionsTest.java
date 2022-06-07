package practice;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertionsTest {
	@Test
	public void sample() {
		SoftAssert sa= new SoftAssert();
		
		String name1="Mrinmoy";
		String name2="Mrinmoy";
		//sa.assertEquals(name1,name2);
		
		
		int a=10;
		int b=10;
		//sa.assertEquals(a,b);
		
		byte a1=1;
		byte b1=1;
		//sa.assertEquals(a1,b1);
		
		char c='M';
		char d='M';
		//sa.assertEquals(c,d);
		
		float q=4.8f;
		float r=6.3f;
		//sa.assertEquals(q,r);
		
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
		
		//sa.assertEquals(objArray,objArray1);
		
		
		//sa.assertFalse(false);
		
		//sa.assertNotEquals(objArray, q);
		
		//sa.assertNotNull(objArray1);
		
		//sa.assertNotSame(objArray, objArray1);
		
		//sa.assertNull(objArray1);
		
		
		
	}

}
