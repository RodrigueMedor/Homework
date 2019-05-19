package test.StockPortfolioManager1Portfolio;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import test.StockPortfolioManager1.Iservice.StcokService;
import test.StockPortfolioManager1.domain.Stock;
import test.StockPortfolioManager1.folio.Portfolio;

public class PortfolioTester {
	
	   Portfolio portfolio;	
	   StcokService stockService;
		   
	   
	   public static void main(String[] args){
	      PortfolioTester tester = new PortfolioTester();
	      tester.setUp();
	      System.out.println(tester.testMarketValue()?"pass":"fail");
	   }
	   
	   public void setUp(){
	      //Create a portfolio object which is to be tested		
	      portfolio = new Portfolio();		
	  
	      //Create the mock object of stock service
	      stockService = mock(StcokService.class);		
	  
	      //set the stockService to the portfolio
	      portfolio.setStockService(stockService);
	   }
	   
	   public boolean testMarketValue(){
	    	   
	      //Creates a list of stocks to be added to the portfolio
	      List<Stock> stocks = new ArrayList<Stock>();
	      Stock googleStock = new Stock("1","Google", 10);
	      Stock microsoftStock = new Stock("2","Microsoft",100);	
	 
	      stocks.add(googleStock);
	      stocks.add(microsoftStock);

	      //add stocks to the portfolio
	      portfolio.setStocks(stocks);

	      //mock the behavior of stock service to return the value of various stocks
	      when(stockService.getPrice(googleStock)).thenReturn(60.00);
	      when(stockService.getPrice(microsoftStock)).thenReturn(1000.00);		

	      double marketValue = portfolio.getMarketValue();		
	      return marketValue == 100500.0;
	   }

}
