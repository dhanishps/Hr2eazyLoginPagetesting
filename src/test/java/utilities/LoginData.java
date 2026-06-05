package utilities;

import org.testng.annotations.DataProvider;

public class LoginData {
	
	// indices is used to which row data only you need to test

	@DataProvider(name = "LoginData",indices = {0,2}, parallel=true)
	 public  Object[][] datas() {
		Object [] [] obj=new Object [] [] {
			{"Dhuru","qaz4321"},     
			{"ann","qaz43211"},  
			{"kani","qaz4321"},    
			{"aran","qaz"},    
			{"vinitha","qaz4321"}  
			
		};
		return obj;
	}
	
	
}
