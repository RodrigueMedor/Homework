package test.StockPortfolioManager1.test;

import static org.mockito.Mockito.when;
import test.StockPortfolioManager1.MathApplication;
import test.StockPortfolioManager1.service.CalculatorService;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;



public class MathApplicationTester {
	
	
	   //@InjectMocks annotation is used to create and inject the mock object
	   @InjectMocks 
	   MathApplication mathApplication = new MathApplication();

	   //@Mock annotation is used to create the mock object to be injected
	   @Mock
	   CalculatorService calcService;

	   @Test
	   public void testAdd(){
	      //add the behavior of calc service to add two numbers
	      when(calcService.add(10.0,20.0)).thenReturn(30.00);
			
	      //test the add functionality
	      Assert.assertEquals(mathApplication.add(10.0, 20.0),30.0,0);
	   }


}
