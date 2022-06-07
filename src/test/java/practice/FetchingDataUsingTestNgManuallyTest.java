package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FetchingDataUsingTestNgManuallyTest {
	@Test(dataProvider="getdata")
	public void multipldata(String name, String phnumber) {
		System.out.println(name);
		System.out.println(phnumber);
		
	}
	@DataProvider
	public Object[][] getdata() {
		Object[][] objArray = new Object[5][2];
		objArray[0][0]="Verma";
		objArray[0][1]="12345678904";
		
		objArray[1][0]="Kumar";
		objArray[1][1]="4567891230";
		
		objArray[2][0]="Panigrahi";
		objArray[2][1]="7894561230";
		
		objArray[3][0]="Mishra";
		objArray[3][1]="2587413690";
		
		objArray[4][0]="Dutta";
		objArray[4][1]="7630215489";
		return objArray;
	}

}
