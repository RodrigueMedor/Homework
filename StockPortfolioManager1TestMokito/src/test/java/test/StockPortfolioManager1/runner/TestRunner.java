package test.StockPortfolioManager1.runner;


import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;

import test.StockPortfolioManager1.test.MathApplicationTester;

public class TestRunner {
	
	   public static void main(String[] args) {
		      org.junit.runner.Result result = JUnitCore.runClasses(MathApplicationTester.class);
		      
		      for (Failure failure : result.getFailures()) {
		         System.out.println(failure.toString());
		      }
		      
		      System.out.println(result.wasSuccessful());
		   }

}