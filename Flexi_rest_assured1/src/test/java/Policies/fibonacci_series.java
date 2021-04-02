package Policies;
//import static io.restassured.RestAssured.*;
//import static org.hamcrest.Matchers.*;
//import io.restassured.response.Response;
//import java.util.regex.Matcher;
import org.testng.annotations.Test;

//RUN THIS AS JAVA PROGRAM 

public class fibonacci_series {
	
	@Test

	
		public static void main(String args[])  
		 {    
		 int n1=0,n2=1,n3,i,count=10;    
		    
		 for(i=2;i<count;++i)//loop starts from 2 because 0 and 1 are already printed    
		 {    
		  n3=n1+n2;    
		  System.out.print(" "+n3);    
		  n1=n2;    
		  n2=n3;    
		 }    
		  
		}
}  
	
	
	






//	 System.out.print(n1+" "+n2);//printing 0 and 1    
