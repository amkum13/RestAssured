package data.driven.tests;

import org.testng.annotations.DataProvider;


public class Test_ZDataForTests {

	@DataProvider(name = "dataForPost")
	public Object[][] dataForPost(){			//function for data provider
		//		Object[][] data = new Object[2][3];     //static object content
		//		
		//		data[0][0]= "Albert";
		//		data[0][1]= "Einstein";
		//		data[0][2]= 2;
		//		
		//		data[1][0]= "Thomas";
		//		data[1][1]= "Edision";
		//		data[1][2]= 1;
		//		
		//		return data;

		//dynamic object content

		return new Object[][] {
			{"Graham", "Bell", 1},
			{"Henry","Ford",2}
		};
	}


	@DataProvider(name = "dataForDelete")
	public Object[] dataForDelete(){ 

		return new Object[] {3,4};
	}
}
