package test.StockPortfolioManager1.folio;

import java.util.List;

import test.StockPortfolioManager1.Iservice.StcokService;
import test.StockPortfolioManager1.domain.Stock;

public class Portfolio {
	
	   private StcokService stockService;
	   private List<Stock> stocks;

	   public StcokService getStockService() {
	      return stockService;
	   }
	   
	   public void setStockService(StcokService stockService) {
	      this.stockService = stockService;
	   }

	   public List<Stock> getStocks() {
	      return stocks;
	   }

	   public void setStocks(List<Stock> stocks) {
	      this.stocks = stocks;
	   }

	   public double getMarketValue(){
	      double marketValue = 0.0;
	      
	      for(Stock stock:stocks){
	         marketValue += stockService.getPrice(stock) * stock.getQuantity();
	      }
	      return marketValue;
	   }


}
